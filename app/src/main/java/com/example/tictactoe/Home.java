package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    boolean gameActive=true;
    int activePlayer=0;
    int gameState[]={2,2,2,2,2,2,2,2,2};
    int[][] winPosition={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void playerTap(View view){
        ImageView img=(ImageView)view;
       int tappedImage=Integer.parseInt(img.getTag().toString());
       if(!gameActive){
           gameReset(view);
       }
       if(gameState[tappedImage]==2){
           gameState[tappedImage]=activePlayer;

           if(activePlayer==0){
               img.setImageResource(R.drawable.x);
               activePlayer=1;
               TextView status=findViewById(R.id.status);
               status.setText("Your Turn (O)");
           }
           else{
               img.setImageResource(R.drawable.o);
               activePlayer=0;
               TextView status=findViewById(R.id.status);
               status.setText("Your Turn (X)");
           }
       }
       for(int[] winPositions:winPosition){
           if(gameState[winPositions[0]]==gameState[winPositions[1]] &&
                   gameState[winPositions[1]]==gameState[winPositions[2]] &&
                   gameState[winPositions[0]]!=2){
               //someone won!
               String winner;
               gameActive=false;
               if(gameState[winPositions[0]]==0){
                   winner=" X has won!";
               }
               else{
                   winner=" O has won!";
               }
               TextView status=findViewById(R.id.status);
               status.setText(winner);
           }
       }


    }

    public void gameReset(View view){
        gameActive=true;
        activePlayer=0;
        for(int i=0;i<gameState.length;i++){
            gameState[i]=2;
        }

    }

    public void reset(View view){
        ((ImageView)findViewById(R.id.imageView16)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView17)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView18)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView20)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView21)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView22)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView23)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView24)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView25)).setImageResource(0);
        TextView status=findViewById(R.id.status);
        status.setText("Your Turn (X)");





    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }
}