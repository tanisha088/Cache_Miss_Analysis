void testcase1() {
    int cachePower = 16; // cache size = 2^16B
    int blockPower = 5; // block size = 2^5B
    int stride = 1;
    int N = 1024;
    long[] A = new long[N];
    String cacheType = "DirectMapped";

    for (int i = 0;i < N;i+=1){
        A[i] = 0;
    }
}

void testcase2() {
    int cachePower = 16; // cache size = 2^16B
    int blockPower = 5; // block size = 2^5B
    int N = 256;
    int[][] Z = new int[N][N];
    String cacheType = "DirectMapped";
    for (int i = 0; i < N; i += 1) {
        for (int j = 0; j < N; j += 1) {
            Z[i][j] = 0;
        }
    }
}

//jik
void testcase3() {
    int cachePower = 18; // cache size = 2^18B
    int blockPower = 5; // block size = 2^6B
    int N = 512;
    int[][] A = new int[N][N];
    int[][] B = new int[N][N];
    int[][] C = new int[N][N];
    String cacheType = "FullyAssociative";
    for (int j = 0; j < N; j += 1) {
        for (int i = 0; i < N; i += 1) {
            int sum = 0;
            for (int k = 0; k < N; k += 1) {
                sum += A[i][k] * B[k][j];
            }
            C[i][j] = sum;
        }
    }
}

//jik
void testcase4() {
    int cachePower = 18; // cache size = 2^18B
    int blockPower = 5; // block size = 2^6B
    int N = 512;
    int[][] A = new int[N][N];
    int[][] B = new int[N][N];
    int[][] C = new int[N][N];
    String cacheType = "DirectMapped";
    for (int j = 0; j < N; j += 1) {
        for (int i = 0; i < N; i += 1) {
            int sum = 0;
            for (int k = 0; k < N; k += 1) {
                sum += A[i][k] * B[k][j];
            }
            C[i][j] = sum;
        }
    }
}


//ijk 
void testcase5() {
    int cachePower = 18; // cache size = 2^18B
    int blockPower = 5; // block size = 2^6B
    int N = 512;
    int[][] A = new int[N][N];
    int[][] B = new int[N][N];
    int[][] C = new int[N][N];
    String cacheType = "FullyAssociative";
    for (int j = 0; j < N; j += 1) {
        for (int i = 0; i < N; i += 1) {
            int sum = 0;
            for (int k = 0; k < N; k += 1) {
                sum += A[j][k] * B[k][i];
            }
            C[j][i] = sum;
        }
    }
}

//ijk 
void testcase5() {
    int cachePower = 18; // cache size = 2^18B
    int blockPower = 5; // block size = 2^6B
    int N = 512;
    int[][] A = new int[N][N];
    int[][] B = new int[N][N];
    int[][] C = new int[N][N];
    String cacheType = "DirectMapped";
    for (int j = 0; j < N; j += 1) {
        for (int i = 0; i < N; i += 1) {
            int sum = 0;
            for (int k = 0; k < N; k += 1) {
                sum += A[j][k] * B[k][i];
            }
            C[j][i] = sum;
        }
    }
}


//ikj 
void testcase5() {
    int cachePower = 18; // cache size = 2^18B
    int blockPower = 5; // block size = 2^6B
    int N = 512;
    int[][] A = new int[N][N];
    int[][] B = new int[N][N];
    int[][] C = new int[N][N];
    String cacheType = "FullyAssociative";
    for (int i = 0; i < N; i += 1) {
        for (int k = 0; k < N; k += 1) {
            int sum = 0;
            for (int j = 0; j < N; j += 1) {
                sum += A[i][k] * B[k][j];
            }
            C[i][j] = sum;
        }
    }
}

//ikj
void testcase6() {
    int cachePower = 18; // cache size = 2^18B
    int blockPower = 5; // block size = 2^6B
    int N = 512;
    int[][] A = new int[N][N];
    int[][] B = new int[N][N];
    int[][] C = new int[N][N];
    String cacheType = "DirectMapped";
    for (int i = 0; i < N; i += 1) {
        for (int k = 0; k < N; k += 1) {
            int sum = 0;
            for (int j = 0; j < N; j += 1) {
                sum += A[i][k] * B[k][j];
            }
            C[i][j] = sum;
        }
    }
}




void testcase6() {
    int cachePower = 16; // cache size = 2^16B
    int blockPower = 5; // block size = 2^5B
    int N = 256;
    int M = 32;
    int[][] Z = new int[M][N];
    String cacheType = "DirectMapped";
    for (int i = 0; i < M; i += 1) {
        for (int j = 0; j < N; j += 1) {
            Z[i][j] = 0;
        }
    }
}

void testcase6() {
    int cachePower = 16; // cache size = 2^16B
    int blockPower = 5; // block size = 2^5B
    int N = 256;
    int M = 512;
    int[][] Z = new int[M][N];
    String cacheType = "DirectMapped";
    for (int i = 0; i < M; i += 1) {
        for (int j = 0; j < N; j += 1) {
            Z[i][j] = 0;
        }
    }
}

void testcase7() {
    int cachePower = 16; // cache size = 2^16B
    int blockPower = 5; // block size = 2^5B
    int N = 256;
    int[][][] Z = new int[N][N][N];
    String cacheType = "DirectMapped";
    for (int i = 0; i < N; i += 1) {
        for (int j = 0; j < N; j += 1){ 
	  for (int k=0 ;k< N; k+=1){
            Z[i][j][k] = 0;
	}
        }
    }
}
