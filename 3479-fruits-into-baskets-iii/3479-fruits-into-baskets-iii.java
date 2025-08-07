class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = baskets.length;
        int blockSize = (int) Math.sqrt(n); 
        int blocksCount = (n + blockSize - 1) / blockSize;
        int[] blockMax = new int[blocksCount];

        for (int i = 0; i < n; i++) {
            int blockIndex = i / blockSize; 
            blockMax[blockIndex] = Math.max(blockMax[blockIndex], baskets[i]); 
        }

        int unplacedCount = 0;

        for (int fruit : fruits) {
            boolean placed = false;

            for (int block = 0; block < blocksCount && !placed; block++) {
                if (blockMax[block] < fruit) { 
                    continue; 
                }

                int start = block * blockSize; 
                int end = Math.min(start + blockSize, n); 

                for (int i = start; i < end; i++) {
                    if (baskets[i] >= fruit) {
                        baskets[i] = 0; 
                        placed = true; 

                        blockMax[block] = 0; 
                        for (int j = start; j < end; j++) {
                            blockMax[block] = Math.max(blockMax[block], baskets[j]); 
                        }
                        break; 
                    }
                }
            }

            if (!placed) {
                unplacedCount++; 
            }
        }

        return unplacedCount;
    }
}