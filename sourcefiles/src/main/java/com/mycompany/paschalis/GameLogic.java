/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.paschalis;

import java.util.Random;

/**
 *
 * @author ilias
 */
public class GameLogic {
     
    Random rand = new Random();
    
    // 0 = kamia narki konta
    // 1 - 8 narkes konta
    // >= 9 = narki

    private int[] boxesRow1 = {0,0,0,0,0,0,0,0,0};
    private int[] boxesRow2 = {0,0,0,0,0,0,0,0,0};
    private int[] boxesRow3 = {0,0,0,0,0,0,0,0,0};
    private int[] boxesRow4 = {0,0,0,0,0,0,0,0,0};
    private int[] boxesRow5 = {0,0,0,0,0,0,0,0,0};
    private int[] boxesRow6 = {0,0,0,0,0,0,0,0,0};
    private int[] boxesRow7 = {0,0,0,0,0,0,0,0,0};
    private int[] boxesRow8 = {0,0,0,0,0,0,0,0,0};
    private int[] boxesRow9 = {0,0,0,0,0,0,0,0,0};
    
    private int[] boxes1 = {0,0,0,0,0,0,0,0,0};
    private int[] boxes2 = {0,0,0,0,0,0,0,0,0};
    private int[] boxes3 = {0,0,0,0,0,0,0,0,0};
    private int[] boxes4 = {0,0,0,0,0,0,0,0,0};
    private int[] boxes5 = {0,0,0,0,0,0,0,0,0};
    private int[] boxes6 = {0,0,0,0,0,0,0,0,0};
    private int[] boxes7 = {0,0,0,0,0,0,0,0,0};
    private int[] boxes8 = {0,0,0,0,0,0,0,0,0};
    private int[] boxes9 = {0,0,0,0,0,0,0,0,0};
    
    private int dificultyLvl = 1;
    
    private final int numberOfBoxes = 81;
    
    private int numberOfMines = 0;
    
    private int numberOfNonMines = numberOfBoxes;
    
    private int numberOfRemainingBoxes = numberOfBoxes;
    
    private int score = 0;
    
    private Boolean hasLost = false;
    
    GameLogic(){
        newGame();
    }
    
    // seters:
    
    public void setDificultyLvl(int Dificulty){
        dificultyLvl = Dificulty;
    }
    
    public void setScore(int newScore){
        score = newScore;
    }
    
    // getters:
    
    public int getScore(){
        return score;
    }
    
    public int getNumberOfMines(){
        return numberOfMines;
    }
    
    public Boolean getHasLost(){
        return hasLost;
    }
    
    public int getValueOf(int row, int colum){
        int r = -1;
        colum--;
        
        switch(row){
            case 1:
                r = boxesRow1[colum];
                boxes1[colum] = 1;
                break;
            case 2:
                r = boxesRow2[colum];
                boxes2[colum] = 1;
                break;
            case 3:
                r = boxesRow3[colum];
                boxes3[colum] = 1;
                break;
            case 4:
                r = boxesRow4[colum];
                boxes4[colum] = 1;
                break;
            case 5:
                r = boxesRow5[colum];
                boxes5[colum] = 1;
                break;
            case 6:
                r = boxesRow6[colum];
                boxes6[colum] = 1;
                break;
            case 7:
                r = boxesRow7[colum];
                boxes7[colum] = 1;
                break;
            case 8:
                r = boxesRow8[colum];
                boxes8[colum] = 1;
                break;
            case 9:
                r = boxesRow9[colum];
                boxes9[colum] = 1;
                break;
                
        }
        
        return r;
    }
    
    public int hasBeenOpened(int row, int colum){
        int r = -1;
        colum--;
        
        switch(row){
            case 1:
                r = boxes1[colum];
                break;
            case 2:
                r = boxes2[colum];
                break;
            case 3:
                r = boxes3[colum];
                break;
            case 4:
                r = boxes4[colum];
                break;
            case 5:
                r = boxes5[colum];
                break;
            case 6:
                r = boxes6[colum];
                break;
            case 7:
                r = boxes7[colum];
                break;
            case 8:
                r = boxes8[colum];
                break;
            case 9:
                r = boxes9[colum];
                break;
                
        }
        
        return r;
    }
    
    /**
     * 
     *  midenizei ton xarti
     */
    private void resetBoxes(){
        numberOfMines = 0;
        numberOfNonMines = numberOfBoxes;
        for (int i = 0; i < 9; i++){
            boxesRow1[i] = 0;
            boxesRow2[i] = 0;
            boxesRow3[i] = 0;
            boxesRow4[i] = 0;
            boxesRow5[i] = 0;
            boxesRow6[i] = 0;
            boxesRow7[i] = 0;
            boxesRow8[i] = 0;
            boxesRow9[i] = 0;
            
            boxes1[i] = 0;
            boxes2[i] = 0;
            boxes3[i] = 0;
            boxes4[i] = 0;
            boxes5[i] = 0;
            boxes6[i] = 0;
            boxes7[i] = 0;
            boxes8[i] = 0;
            boxes9[i] = 0;
            
        }
    }
    
    /**
     * 
     * Bazei tixea narkes kai enimeronei ta diplana koutia gia to an uparxei 
     * konta narki
     */
    public void newGame(){
        resetBoxes();
        hasLost = false;
        score = 0;
        
        int randomNum;
        
        // 1st row
        for (int i = 0; i < 9; i++){
            randomNum = rand.nextInt(10 - dificultyLvl);
            
            if (randomNum == 0){
                numberOfMines++;
                numberOfNonMines--;
                
                if (i > 0){
                    boxesRow1[i - 1]++;
                    boxesRow2[i - 1]++;
                }
                boxesRow1[i] = 9;
                boxesRow2[i]++; 
                
                if (i < 8){
                    boxesRow1[i + 1]++;
                    boxesRow2[i + 1]++;
                }
            }
            
        }
        
        // 2nd row
        for (int i = 0; i < 9; i++){
            randomNum = rand.nextInt(10 - dificultyLvl);
            
            if (randomNum == 0){
                numberOfMines++;
                numberOfNonMines--;
                
                if (i > 0){
                    boxesRow1[i - 1]++;
                    boxesRow2[i - 1]++;
                    boxesRow3[i - 1]++;
                }
                boxesRow1[i]++;
                boxesRow2[i] = 9;
                boxesRow3[i]++; 
                
                if (i < 8){
                    boxesRow1[i + 1]++;
                    boxesRow2[i + 1]++;
                    boxesRow3[i + 1]++;
                }
            }
            
        }
        // 3rd row
        for (int i = 0; i < 9; i++){
            randomNum = rand.nextInt(10 - dificultyLvl);
            
            if (randomNum == 0){
                numberOfMines++;
                numberOfNonMines--;
                
                if (i > 0){
                    boxesRow2[i - 1]++;
                    boxesRow3[i - 1]++;
                    boxesRow4[i - 1]++;
                }
                boxesRow2[i]++;
                boxesRow3[i] = 9;
                boxesRow4[i]++; 
                
                if (i < 8){
                    boxesRow2[i + 1]++;
                    boxesRow3[i + 1]++;
                    boxesRow4[i + 1]++;
                }
            }
            
        }
        // 4th row
        for (int i = 0; i < 9; i++){
            randomNum = rand.nextInt(10 - dificultyLvl);
            
            if (randomNum == 0){
                numberOfMines++;
                numberOfNonMines--;
                
                if (i > 0){
                    boxesRow3[i - 1]++;
                    boxesRow4[i - 1]++;
                    boxesRow5[i - 1]++;
                }
                boxesRow3[i]++;
                boxesRow4[i] = 9;
                boxesRow5[i]++; 
                
                if (i < 8){
                    boxesRow3[i + 1]++;
                    boxesRow4[i + 1]++;
                    boxesRow5[i + 1]++;
                }
            }
            
        }
        // 5th row
        for (int i = 0; i < 9; i++){
            randomNum = rand.nextInt(10 - dificultyLvl);
            
            if (randomNum == 0){
                numberOfMines++;
                numberOfNonMines--;
                
                if (i > 0){
                    boxesRow4[i - 1]++;
                    boxesRow5[i - 1]++;
                    boxesRow6[i - 1]++;
                }
                boxesRow4[i]++;
                boxesRow5[i] = 9;
                boxesRow6[i]++; 
                
                if (i < 8){
                    boxesRow4[i + 1]++;
                    boxesRow5[i + 1]++;
                    boxesRow6[i + 1]++;
                }
            }
            
        }
        // 6th row
        for (int i = 0; i < 9; i++){
            randomNum = rand.nextInt(10 - dificultyLvl);
            
            if (randomNum == 0){
                numberOfMines++;
                numberOfNonMines--;
               
                if (i > 0){
                    boxesRow5[i - 1]++;
                    boxesRow6[i - 1]++;
                    boxesRow7[i - 1]++;
                }
                boxesRow5[i]++;
                boxesRow6[i] = 9;
                boxesRow7[i]++; 
                
                if (i < 8){
                    boxesRow5[i + 1]++;
                    boxesRow6[i + 1]++;
                    boxesRow7[i + 1]++;
                }
            }
            
        }
        // 7th row
        for (int i = 0; i < 9; i++){
            randomNum = rand.nextInt(10 - dificultyLvl);
            
            if (randomNum == 0){
                numberOfMines++;
                numberOfNonMines--;
                
                if (i > 0){
                    boxesRow6[i - 1]++;
                    boxesRow7[i - 1]++;
                    boxesRow8[i - 1]++;
                }
                boxesRow6[i]++;
                boxesRow7[i] = 9;
                boxesRow8[i]++; 
                
                if (i < 8){
                    boxesRow6[i + 1]++;
                    boxesRow7[i + 1]++;
                    boxesRow8[i + 1]++;
                }
            }
            
        }
        // 8th row
        for (int i = 0; i < 9; i++){
            randomNum = rand.nextInt(10 - dificultyLvl);
            
            if (randomNum == 0){
                numberOfMines++;
                numberOfNonMines--;
                
                if (i > 0){
                    boxesRow7[i - 1]++;
                    boxesRow8[i - 1]++;
                    boxesRow9[i - 1]++;
                }
                boxesRow7[i]++;
                boxesRow8[i] = 9;
                boxesRow9[i]++; 
                
                if (i < 8){
                    boxesRow7[i + 1]++;
                    boxesRow8[i + 1]++;
                    boxesRow9[i + 1]++;
                }
            }
            
        }
        // 9th row
        for (int i = 0; i < 9; i++){
            randomNum = rand.nextInt(10 - dificultyLvl);
            
            if (randomNum == 0){
                numberOfMines++;
                numberOfNonMines--;
                
                if (i > 0){
                    boxesRow8[i - 1]++;
                    boxesRow9[i - 1]++;
                }
                boxesRow8[i]++;
                boxesRow9[i] = 9; 
                
                if (i < 8){
                    boxesRow8[i + 1]++;
                    boxesRow9[i + 1]++;
                }
            }
            
        }
        
        numberOfRemainingBoxes = numberOfNonMines;
    }
    
    public int checkBox(int row, int colum, boolean flagMode){
        int box = getValueOf(row, colum);
        
        if (box >= 9){
            box = -1;
            if (!flagMode){
                hasLost = true;
            }
            else{
                score = score + 10;
            }
        }
        else {
            score++;
            numberOfRemainingBoxes--;
            if (flagMode){
                hasLost = true;
                
            }
            
        }
        
        // -1 = mine
        return box;
    }
    
}
