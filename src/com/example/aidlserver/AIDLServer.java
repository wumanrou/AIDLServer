package com.example.aidlserver;

import java.util.Timer;
import java.util.TimerTask;
import com.example.aidlserver.Song.Stub;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class AIDLServer extends Service {
	private String[] names=new String[]{"Funny Day","Reset","Unity"};
	private String[] authors=new String[]{"Nichole Alden","theFatRat","Tiger JK¡¢jinsi"};
	private String name,author;
	private SongBinder songBinder;
	private Timer timer=new Timer();
	public class SongBinder extends Stub{
		public String getName()throws RemoteException{
			return name;
		}
		public String getAuthor()throws RemoteException{
			return author;
		}
	}

    @Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return songBinder;
	}
	public void onCreate(){
		super.onCreate();
		songBinder=new SongBinder();
		timer.schedule(new TimerTask(){
			public void run(){
				int rand=(int)(Math.random()*3);
				
				name=names[rand];
				author=authors[rand];
			}
		},1000);
	}
	public void onDestory(){
		super.onDestroy();
		timer.cancel();
	}
}


	


