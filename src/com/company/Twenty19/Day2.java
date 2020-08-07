package com.company.Twenty19;


public class Day2 {
    static int instructionPointer = -1;
    static int[] memory;

    public static void main(String[] args) {
        memory = getMemory();
        restoreToPreviousState();
        runProgram();
        System.out.println("The value left at position 0 is " + memory[0]);
    }

    private static void runProgram() {
        while (instructionPointer < memory.length - 3) {
            int opcode = getNextParameter();
            if(opcode == 99) {
                System.out.println("Stopping because got halting instruction");
                break;
            } else {
                runInstruction(opcode);
            }
        }
    }

    private static void runInstruction(int opcode) {
        int res;
        if (opcode == 1){
            res = memory[getNextParameter()] + memory[getNextParameter()];
        }else if (opcode == 2){
            res = memory[getNextParameter()] * memory[getNextParameter()];
        }else {
            return;
        }
        memory[getNextParameter()] = res;

    }

    private static int getNextParameter() {
        return memory[++instructionPointer];
    }

    private static int[] getMemory() {
        return new int[]{1, 0, 0, 3, 1, 1, 2, 3, 1, 3, 4, 3, 1, 5, 0, 3, 2, 1, 13, 19, 1, 9, 19, 23, 2, 13, 23, 27, 2,
                27, 13, 31, 2, 31, 10, 35, 1, 6, 35, 39, 1, 5, 39, 43, 1, 10, 43, 47, 1, 5, 47, 51, 1, 13, 51, 55, 2,
                55, 9, 59, 1, 6, 59, 63, 1, 13, 63, 67, 1, 6, 67, 71, 1, 71, 10, 75, 2, 13, 75, 79, 1, 5, 79, 83, 2, 83,
                6, 87, 1, 6, 87, 91, 1, 91, 13, 95, 1, 95, 13, 99, 2, 99, 13, 103, 1, 103, 5, 107, 2, 107, 10, 111, 1,
                5, 111, 115, 1, 2, 115, 119, 1, 119, 6, 0, 99, 2, 0, 14, 0};
    }

    private static void restoreToPreviousState() {
        memory[1] = 12;
        memory[2] = 2;
    }
}
