import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.concurrent.TimeUnit;
import javax.sound.sampled.AudioSystem;
import javax.swing.*;
import java.applet.*;
import java.net.*;
import sun.audio.*;
import javax.sound.sampled.*;

public class HangmanPanel extends JPanel implements MouseListener{	
	public Image img;
	public ImageIcon icon; 
	public Image img2;
	public ImageIcon icon2;
	public Image img3;
	public ImageIcon icon3; 
	public Image img4;
	public ImageIcon icon4; 
	public Image img5;
	public ImageIcon icon5; 
	public Image img6;
	public ImageIcon icon6; 
	public Image img7;
	public ImageIcon icon7; 
	public Image img8;
	public ImageIcon icon8; 
	public Image img9;
	public ImageIcon icon9; 
	public Image img10;
	public ImageIcon icon10; 
	public int score=100;
	public int wrong;

	HangmanCheckString chString;
	public HangmanPanel(){

		chString = new HangmanCheckString();
		chString.chooseWord();
		this.setSize(100,500);
		this.setVisible(true);
		this.setFocusable(true);
		
		icon = new ImageIcon("image/hangman_bg.jpg");
		img = icon.getImage();
		
		icon2 = new ImageIcon("image/alphabet.png");
		img2 = icon2.getImage();
		
		icon3 = new ImageIcon("image/head.png");
		img3 = icon3.getImage();
		
		icon4 = new ImageIcon("image/left.png");
		img4 = icon4.getImage();
		
		icon5 = new ImageIcon("image/right.png");
		img5 = icon5.getImage();
		
		icon6= new ImageIcon("image/body.png");
		img6 = icon6.getImage();
		
		icon7 = new ImageIcon("image/foot_left.png");
		img7 = icon7.getImage();
		
		icon8 = new ImageIcon("image/foot_right.png");
		img8 = icon8.getImage();
		
		icon9 = new ImageIcon("image/angry.png");
		img9 = icon9.getImage();
		
		icon10 = new ImageIcon("image/happy.png");
		img10 = icon10.getImage();
		
		addMouseListener(this);	
		wrong = 0;
		
		}

	public static void PlaySound(File Sound) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			Thread.sleep(clip.getMicrosecondLength()/1000);
			clip.start(); 
		}
		catch(Exception as) {
			
			System.out.println(as);
		}
	}
	

	/*public static void StopSound(File Sound) {
	
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			Thread.sleep(clip.getMicrosecondLength()/1000);
			clip.start(); 
		}
		catch(Exception as) {
			
			System.out.println(as);
		}
		
	}
	*/
	public void paint(Graphics g){ 
		String s_score= Integer.toString(score);
	
		
		g.drawImage(img,0,0,700,500,null);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(375, 95, 308, 308);
		g.drawImage(img2,380,100,300,300, null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial",Font.ITALIC,68));
		g.drawChars(chString.hangmanLetters, 0, chString.charArray.length, 180, 460);

		if(chString.wrongGuess == 1){
			g.drawImage(img10, 135, 135, 100, 100, null);//head
		}
		if(chString.wrongGuess == 2){		
			g.drawImage(img10, 135, 135, 100, 100, null);//head
			g.drawImage(img6, 135, 200, 100, 160, null);//body
		}
		if(chString.wrongGuess == 3){		
			g.drawImage(img10, 135, 135, 100, 100, null);//head
			g.drawImage(img6, 135, 200, 100, 160, null);//body
			g.drawImage(img4, 100, 200, 120, 120, null);// left arm
		}
		if(chString.wrongGuess == 4){		
			g.drawImage(img10, 135, 135, 100, 100, null);//head
			g.drawImage(img6, 135, 200, 100, 160, null);//body
			g.drawImage(img4, 100, 200, 120, 120, null);// left arm
			g.drawImage(img5, 155, 210, 112, 112, null);// right arm
		}
		if(chString.wrongGuess == 5){	
			g.drawImage(img10, 135, 135, 100, 100, null);//head
			g.drawImage(img6, 135, 200, 100, 160, null);//body
			g.drawImage(img4, 100, 200, 120, 120, null);// left arm
			g.drawImage(img5, 155, 210, 112, 112, null);// right arm
			g.drawImage(img7, 115, 270, 100, 100, null);// left leg
		}
		if(chString.wrongGuess == 6){	
			g.drawImage(img9, 120, 135, 100, 100, null);//head
			g.drawImage(img6, 135, 200, 100, 160, null);//body
			g.drawImage(img4, 100, 200, 120, 120, null);// left arm
			g.drawImage(img5, 155, 210, 112, 112, null);// right arm
			g.drawImage(img7, 115, 270, 100, 100, null);// left leg
			g.drawImage(img8, 148, 270, 100, 100, null);// right leg
		}
		if(chString.winOrLoose == true){
			
			File win1 = new File("win.wav");
			PlaySound(win1);
			g.setColor(Color.green);			
			g.drawString("KAZANDINIZ!", 80, 250);
			score+=100;
			
			
		
			g.setColor(Color.white);
			g.fillRect(40, 418, 120, 60);
			g.setColor(Color.red);
			g.setFont(new Font("Arial",Font.ITALIC,18));
			g.drawString("YENÝ OYUN", 45, 450);
			g.setColor(Color.BLACK);			
			g.drawString("score:"+ 100,400, 75);

		}
		
		
		if(chString.wrongGuess == 6){			
			File lose = new File("lose.wav");
			PlaySound(lose);
			g.setColor(Color.red);
			g.drawString("YENÝLDÝNÝZ!", 80, 250);
			
			
			
			g.setColor(Color.white);			
			g.fillRect(40, 418, 120, 60);
			g.setColor(Color.red);
			g.setFont(new Font("Arial",Font.ITALIC,18));
			g.drawString("YENÝ OYUN", 45, 450);	

			g.setColor(Color.BLACK);			
			g.drawString("score:"+ s_score,400, 75);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	
		int mX = e.getX(); 
		int mY = e.getY();
		
	 // When the win
		if(mX > 40 && mX < 140 && mY > 418 && mY < 468 && (chString.wrongGuess == 6 || chString.winOrLoose == true)){
			chString.wrongGuess = 0;
			chString.chooseWord();
			chString.winOrLoose = false;
			for(int i = 0; i < 26; i++){ 
				chString.usedLetterList[i] = '-';
			}
		}
		
		
		// A to G
		if(mX > 386 && mX < 430 && mY > 95 && mY < 170){
		char ch = 'a';
		chString.checkWord(ch);
		}
		if(mX > 432 && mX < 468 && mY > 95 && mY < 170){
			char ch = 'b';
			chString.checkWord(ch);
			}
		if(mX > 470 && mX < 515 && mY > 95 && mY < 170){
			char ch = 'c';
			chString.checkWord(ch);
			}
		if(mX > 515 && mX < 556 && mY > 95 && mY < 170){
			char ch = 'd';
			chString.checkWord(ch);
			}
		if(mX > 555 && mX < 593 && mY > 95 && mY < 170){
			char ch = 'e';
			chString.checkWord(ch);
			}
		if(mX > 593 && mX < 624 && mY > 95 && mY < 170){
			char ch = 'f'; 
			chString.checkWord(ch);
			}
		if(mX > 625 && mX < 670 && mY > 95 && mY < 170){
			char ch = 'g';
			chString.checkWord(ch);
			}
		
		// J to N 
		
		if(mX > 385 && mX < 409 && mY > 172 && mY < 245){
			char ch = 'j';
			chString.checkWord(ch);
			}
		if(mX > 422 && mX < 460 && mY > 172 && mY < 245){
			char ch = 'h';
			chString.checkWord(ch);
			}
		if(mX > 463 && mX < 490 && mY > 172 && mY < 245){
			char ch = 'i';
			chString.checkWord(ch);
			}
		if(mX > 492 && mX < 531 && mY > 172 && mY < 245){
			char ch = 'k';
			chString.checkWord(ch);
			}
		if(mX > 533 && mX < 570 && mY > 172 && mY < 245){
			char ch = 'l';
			chString.checkWord(ch);
			}
		if(mX > 573 && mX < 626 && mY > 172 && mY < 245){
			char ch = 'm';
			chString.checkWord(ch);
			}
		if(mX > 628 && mX < 673 && mY > 172 && mY < 245){
			char ch = 'n';
			chString.checkWord(ch);
			}
		
		// O to U
		
		if(mX > 380 && mX < 425 && mY > 250 && mY < 325){
			char ch = 'o';
			chString.checkWord(ch);
			}
		if(mX > 427 && mX < 458 && mY > 250 && mY < 325){
			char ch = 'p';
			chString.checkWord(ch);
			}
		if(mX > 460 && mX < 510 && mY > 250 && mY < 325){
			char ch = 'q';
			chString.checkWord(ch);
			}
		if(mX > 513 && mX < 552 && mY > 250 && mY < 325){
			char ch = 'r';
			chString.checkWord(ch);
			}
		if(mX > 555 && mX < 592 && mY > 250 && mY < 325){
			char ch = 's';
			chString.checkWord(ch);
			}
		if(mX > 594 && mX < 634 && mY > 250 && mY < 325){
			char ch = 't';
			chString.checkWord(ch);
			}
		if(mX > 637 && mX < 682 && mY > 250 && mY < 325){
			char ch = 'u';
			chString.checkWord(ch);
			}
		
		// V to Z
				
		if(mX > 401 && mX < 446 && mY > 330 && mY < 403){
			char ch = 'v';
			chString.checkWord(ch);
			}
		if(mX > 447 && mX < 512 && mY > 330 && mY < 403){
			char ch = 'w';
			chString.checkWord(ch);
			}
		if(mX > 515 && mX < 556 && mY > 330 && mY < 403){
			char ch = 'x';
			chString.checkWord(ch);
			}
		if(mX > 559 && mX < 602 && mY > 330 && mY < 403){
			char ch = 'y';
			chString.checkWord(ch);
			}
		if(mX > 605 && mX < 650 && mY > 330 && mY < 403){
			char ch = 'z';
			chString.checkWord(ch);
			
			
		}
		repaint();

	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
				
	}
	@Override
	public void mouseExited(MouseEvent e) {
			
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
			
	}
	@Override
	public void mouseReleased(MouseEvent e) {
				
	}

}
