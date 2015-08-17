package com.harunkor.GooglePlayServiceSimpleSample;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.games.Games;
import com.google.example.games.basegameutils.BaseGameActivity;
import com.harunkor.GooglePlayServiceSimpleSample.R;

public class MainActivity extends BaseGameActivity  {
     private EditText edt_skor;
     private Button   btn_kayit;
     private Button   btn_skorlar;
     private Button   btn_rozetler;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		edt_skor=(EditText)findViewById(R.id.edttxt_Score_Input);
		btn_kayit=(Button)findViewById(R.id.SaveScore);
		btn_skorlar=(Button)findViewById(R.id.Leaderboards);
		btn_rozetler=(Button)findViewById(R.id.badges);
		
		beginUserInitiatedSignIn();
		
		btn_kayit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int score = Integer.parseInt(edt_skor.getText().toString());
				Games.Achievements.unlock(getApiClient(), 
						getString(R.string.correct_guess_achievement_badge1));
				Games.Achievements.unlock(getApiClient(), 
						getString(R.string.correct_guess_achievement_badge2));
				Games.Achievements.unlock(getApiClient(), 
						getString(R.string.correct_guess_achievement_badge3));
				
				
				
				
				
				Games.Leaderboards.submitScore(getApiClient(), 
						getString(R.string.number_guesses_leaderboard), 
						score);

			}
		});
		
		btn_skorlar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivityForResult(Games.Leaderboards.getLeaderboardIntent(
						getApiClient(), getString(R.string.number_guesses_leaderboard)), 
						2);
			}
		});
	
		
		btn_rozetler.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivityForResult(Games.Achievements.getAchievementsIntent(
						getApiClient()), 1);
			}
		});
	
		
		
	}

	@Override
	public void onSignInFailed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSignInSucceeded() {
		// TODO Auto-generated method stub
		
	}


}
