import java.util.*;
import static java.util.stream.Collectors.*;
import java.lang.Math;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

// FIXME: You should limit your implementation to this class. You are free to add new auxilliary classes. You do not need to touch the LoopNext.g4 file.
class Analysis extends LoopNestBaseListener {

    // Possible types
    enum Types {
        Byte, Short, Int, Long, Char, Float, Double, Boolean, String
    }

    // Type of variable declaration
    enum VariableType {
        Primitive, Array, Literal
    }

    // Types of caches supported
    enum CacheTypes {
        DirectMapped, SetAssociative, FullyAssociative,
    }

    // auxilliary data-structure for converting strings
    // to types, ignoring strings because string is not a
    // valid type for loop bounds
    final Map<String, Types> stringToType = Collections.unmodifiableMap(new HashMap<String, Types>() {
        private static final long serialVersionUID = 1L;
        {
            put("byte", Types.Byte);
            put("short", Types.Short);
            put("int", Types.Int);
            put("long", Types.Long);
            put("char", Types.Char);
            put("float", Types.Float);
            put("double", Types.Double);
            put("boolean", Types.Boolean);
        }
    });

    // auxilliary data-structure for mapping types to their byte-size
    // size x means the actual size is 2^x bytes, again ignoring strings
    final Map<Types, Integer> typeToSize = Collections.unmodifiableMap(new HashMap<Types, Integer>() {
        private static final long serialVersionUID = 1L;
        {
            put(Types.Byte, 0);
            put(Types.Short, 1);
            put(Types.Int, 2);
            put(Types.Long, 3);
            put(Types.Char, 1);
            put(Types.Float, 2);
            put(Types.Double, 3);
            put(Types.Boolean, 0);
        }
    });

    // Map of cache type string to value of CacheTypes
    final Map<String, CacheTypes> stringToCacheType = Collections.unmodifiableMap(new HashMap<String, CacheTypes>() {
        private static final long serialVersionUID = 1L;

        {
            put("FullyAssociative", CacheTypes.FullyAssociative);
            put("SetAssociative", CacheTypes.SetAssociative);
            put("DirectMapped", CacheTypes.DirectMapped);
        }
    });


    //Declaring all variables and data structures which are used later in this program
    List<HashMap<String, Long>> result;
    HashMap<String, Long> cacheMisses;
    HashMap<String,String> variables;
    HashMap<String,String> arraytype; 
    HashMap<String,Integer> stride;
    HashMap<String,String> arrayindices;
    HashMap<String,Long> arraysize;
    HashMap<String, String> upperbounds;
    String looplevelorder="";
    int cachePower, blockPower, wordPower;
    CacheTypes cacheType;


    public Analysis() {
	 //Initializing the required variables and data structures for each testcase, such that only the details of current testcase is stored
	result = new ArrayList<HashMap<String, Long>>();	
	variables = new HashMap<String, String>();
	arraytype= new HashMap<String, String>();
	arraysize =new HashMap<String,Long>(); 
	upperbounds= new HashMap<String, String>();
	stride =new HashMap<String,Integer>();
	arrayindices=new HashMap<String,String>();
	looplevelorder="";
    }

    

    // FIXME: Feel free to override additional methods from
    // LoopNestBaseListener.java based on your needs.
    // Method entry callback

    
    
    @Override public void enterMethodBody(LoopNestParser.MethodBodyContext ctx) { 
	//removing all the data of previous methods (testcases)
        cacheMisses= new HashMap<String, Long>();
	variables.clear();
	arraytype.clear();
	arraysize.clear();
	upperbounds.clear();
	stride.clear();
	arrayindices.clear();
	looplevelorder="";
    }


     @Override public void enterLocalVariableDeclaration(LoopNestParser.LocalVariableDeclarationContext ctx) 
     {	
        String variable_name =ctx.variableDeclarator().variableDeclaratorId().getText();

        if(ctx.unannType()!=null && ctx.unannType().unannArrayType()!=null) //Checking if the variable is an array
        {	
	   String datatype = ctx.unannType().unannArrayType().unannPrimitiveType().getText();	 
	   arraytype.put(variable_name, datatype ); //Storing details of datatypes of each array in arraytype HashMap

	   long size=1L;
	 
	   //Calculating size of array by multiplying size of each dimension
	   for(LoopNestParser.DimExprContext x: ctx.variableDeclarator().arrayCreationExpression().dimExprs().dimExpr())
		size *= Long.parseLong(variables.get(x.expressionName().getText()));  
	
	   arraysize.put(variable_name, size);
        }
        else    				    //for variables other than array
        {
           variables.put(variable_name, ctx.variableDeclarator().literal().getText());
        }
     }


     @Override public void enterArrayAccess(LoopNestParser.ArrayAccessContext ctx) { 
		
	     /* This function is invoked whenever an array is accessed.
		Here, the variables which are used as array indices, are stored as a string in arrayindices HashMap 
		   EXAMPLE : for sum += A[i][k] , "A" and "ik" would be stored as key and value respectively, in arrayindices 
 	     */
		storeArrayIndices(ctx.expressionName());			
      }


     @Override public void enterArrayAccess_lfno_primary(LoopNestParser.ArrayAccess_lfno_primaryContext ctx) { 
		
	     /* This function is invoked whenever an array is used for storing values ,i.e., when the array is used in LHS as given in example.
	        Here, the variables which are used as array indices, are stored as a string in arrayindices HashMap 
		   EXAMPLE : for A[i][k] = 0 , "A" and "ik" would be stored as key and value respectively, in arrayindices 
 	     */
		storeArrayIndices(ctx.expressionName());
      }




      public void storeArrayIndices(List<LoopNestParser.ExpressionNameContext> ctx)
      {
	      String s="";
	      for(LoopNestParser.ExpressionNameContext x : ctx)
	      s+=x.getText();		
	      arrayindices.put(s.substring(0,1), s.substring(1));
      }




      public void enterForStatement(LoopNestParser.ForStatementContext ctx)
      {
	   //This function would be invoked everytime a for loop is encountered
           String s=ctx.forUpdate().simplifiedAssignment().expressionName(0).getText();
	   looplevelorder += s;
 	   stride.put(s,Integer.parseInt(ctx.forUpdate().simplifiedAssignment().IntegerLiteral().getText()));
	   LoopNestParser.RelationalExpressionContext ob = ctx.forCondition().relationalExpression(); 
	   upperbounds.put(ob.expressionName(0).getText(),ob.expressionName(1).Identifier().getText());	
      }
	



      private void calculateCacheMiss(String array,String indices)
      {
	 int dimension=indices.length();
	 /*
	   Each array can have different data type.So wordPower, for each array, is taken according to its datatype.
	   wordPower, here, is equal to the size of one element of array, which we can get by using the size of datatype of the array.
	 */
	  wordPower  = typeToSize.get(stringToType.get(arraytype.get(array)));

	 /* 
	  Since cachePower and blockPower is given in terms of bytes, we can change it into words by subtracting wordPower from cachePower 	     and blockPower, repectively.
	 */
	 int cachePower = this.cachePower - wordPower;
	 int blockPower = this.blockPower - wordPower;

	 long misses=1L;
	
	 if(dimension==1)					       
	 {
		     misses= cacheMissesFor1DArray(indices,blockPower); //for 1D array
	 }

	 else 
         {	/* EXAMPLE: 
			for(int i; i<N; i++)
			    for(int j; j<N; j++)
				for(int k; k<N; k++)
					A[k][j] = 0;
		
		  For the given example,
			looplevelorder = "ijk" 
			row    = 'j'      		//loop variable for row-wise access
			column = 'k'			//loop variable for column-wise access
			rowvariablelevel = 2		//Since 'j' is in the 2nd loop
			columnvariablelevel=3		//Since 'k' is in the 3rd loop
		*/
	
             int l= indices.length();
	     char row=indices.charAt(l-1); 					
	     char column =indices.charAt(l-2);				
	     int rowvariablelevel = looplevelorder.indexOf(row);		
	     int columnvariablelevel = looplevelorder.indexOf(column);
		
	   /*
	    if the cache capacity is more than array capacity, each mapping technique would give the same value of cache misses for stride=1, as:
	        cache miss= (array capacity)/blockSize;  
	   */
         
	   if(Math.pow(2,cachePower) >= arraysize.get(array)) 
	   {
		misses = arraysize.get(array)/(long)Math.pow(2,blockPower);
	   }    
	   else
	    switch(cacheType)
	    {
              case DirectMapped     : misses=cacheMissesForDirectMapping(row,rowvariablelevel,column,columnvariablelevel,blockPower);
				       break;
      	      case FullyAssociative : misses=cacheMissesForFullyAssociativeMapping(row,rowvariablelevel,column,columnvariablelevel,blockPower);
				       break;
	      case SetAssociative   : misses=cacheMissesForSetAssociativeMapping(row,rowvariablelevel,column,columnvariablelevel,blockPower);
				       break;
	    }  
	  }
	    cacheMisses.put(array, misses);	       
	}





	//Cache miss calculation for 1D array
	public long cacheMissesFor1DArray(String indices,int blockPower)
	{
		/*
		   If stride < blockSize,
			 cache misses = X /blockSize
		   else
			 cache misses = X /stride
		   where, X = number of times array index would change in nested loops
		   EXAMPLE :
			for(int i; i<N; i++)
			    for(int j; j<N; j++)
				for(int k; k<N; k++)
					A[j] = 0;
		      here, value j would be changed N*N times. Therefore, X= N*N     
		*/

		long misses= 1L;
		int i = looplevelorder.indexOf(indices);
	 	while(i>=0)
		{
		    misses *= Integer.parseInt(variables.get(upperbounds.get(Character.toString(looplevelorder.charAt(i)))));
		    i--;
	        }
		int strides=stride.get(indices);
		if(strides <= Math.pow(2,blockPower) )
		{
		    misses /= (long)Math.pow(2,blockPower);
		}
		else
		{ 
		    misses /= strides;	
		}
		return misses;
	}





	//Cache miss calculation for Direct Mapping
	public long cacheMissesForDirectMapping(char row,int rowvariablelevel,char column,int columnvariablelevel,int blockPower)
	{ 	
	   int i = columnvariablelevel;
	   long misses =1L;

		/* ASSUMPTION: cache is large enough to hold atleast a row of array without any replacement. 
		   PATTERN NOTICED: 
		     Consider the following example:
			for(int i; i<N; i++)
			    for(int j; j<N; j++)
				for(int k; k<N; k++)
				   for(int l; l<N; l++)
				     sum = A[j][l] + B[k][j];
		     1. Array A is accessed row-wise. Loop with row accessing variable (here, l), and all the loops with and outside the loop
			with column accessing variable (j in this case) will be used for calculating cache misses. Therefore, for i and j, there 				would be N misses each, and for l, there would be N/blockSize misses. So, total N*N*N/B misses.
		     2. Array B is accessed column-wise. Loops with and outside the loop with column accessing variable (here, k), will be used 			for calculating cache misses, i.e, i ,j and k will be used for the calculation. Therefore, there would be N misses for 				i,j and k each. S, total cache misses= N*N*N.
                */
	   while(i>=0)
	   {
	       misses *= Integer.parseInt(variables.get(upperbounds.get(""+looplevelorder.charAt(i))));
	       i--;
           }
           if( rowvariablelevel > columnvariablelevel ) //If array is accessed row-wise
	   {
			//(number of rows) * (misses per row)
	      misses *= Integer.parseInt(variables.get(upperbounds.get(row+""))) /(long) Math.pow(2,blockPower);     
	   }	  
	   return misses;
	}
        




	//Cache miss calculation for Fully Associative Mapping
	public long cacheMissesForFullyAssociativeMapping(char row,int rowvariablelevel,char column,int columnvariablelevel,int blockPower)
	{
	     /*
	       Assumptions and pattern would be same as direct mapping. The only difference in the pattern observed in this case is that, even   		       if the array is accessed column-wise, there would be 1 miss per block for columns. This is because there is no such restrictions 	       that a block can be placed only in a particular cache line, as i was in case of Direct Mapping. Other points would be same as 		       Direct Mapping.
	     */
	     long misses=1L;
	     int i;
	     char x;
	     if(rowvariablelevel < columnvariablelevel)	//If array is accessed column-wise
	      {
		  x=column;
		  i=rowvariablelevel;
              }
	     else				        //Array is accessed row-wise							
	      {
		  x=row;
		  i=columnvariablelevel;
	      }     
	      while(i>=0)
	      {
		  misses *= Integer.parseInt(variables.get(upperbounds.get(""+looplevelorder.charAt(i))));  
		  i--;
              }
		misses = (Integer.parseInt(variables.get(upperbounds.get(""+x)))*misses)/(long)Math.pow(2,blockPower);
		return misses;
	}





	
	//Cache miss calculation for Set Associative Mapping
	public long cacheMissesForSetAssociativeMapping(char row,int rowvariablelevel,char column,int columnvariablelevel,int blockPower)
	{
	       int i = columnvariablelevel;
	       long misses =1L;
	       while(i>=0)
	       {
	           misses *= Integer.parseInt(variables.get(upperbounds.get(""+looplevelorder.charAt(i))));
	           i--;
               }
               if( rowvariablelevel > columnvariablelevel ) //If array is accessed row-wise
	       {
		             //(number of rows) * (misses per row)     
	           misses *= Integer.parseInt(variables.get(upperbounds.get(row+""))) /(long) Math.pow(2,blockPower);
	       }
	  
	   return misses; 
	}






	@Override public void exitMethodBody(LoopNestParser.MethodBodyContext ctx) { 

		//Stroring all variable details given into local variables
		variables.put("looplevelorder",looplevelorder);
		cachePower = Integer.parseInt(variables.get("cachePower")); 
	        blockPower = Integer.parseInt(variables.get("blockPower")); 
		String c = variables.get("cacheType");
		cacheType=stringToCacheType.get( c.substring(1,c.length()-1)); 
		
		//Calling calculateCacheMiss() for each array
		arrayindices.forEach((array,indices) ->  calculateCacheMiss(array, indices));
		System.out.println(cacheMisses);
		
		//Adding cache misses into result HashMap
		result.add(cacheMisses);		
	}

	
    // End of testcase
   
    @Override
    public void exitTests(LoopNestParser.TestsContext ctx) {
	System.out.println(result);
	
        try {
            FileOutputStream fos = new FileOutputStream("Results.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // FIXME: Serialize your data to a file
             oos.writeObject(result); //Writing result into Result.obj file
            oos.close();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
