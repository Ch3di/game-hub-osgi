package gamecenterserver;

import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRootPane;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import gameApi.GameInterface;
import snake.SnakeGame;
import sokoban.SokobanGame;
import tetris.TetrisGame;



public class GameCenterMenu extends JFrame {
	private ServiceTracker snakeTracker;
	private ServiceTracker sokobanTracker;
	private ServiceTracker tetrisTracker;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		GameCenterMenu game = new GameCenterMenu();
	}

	private BundleContext getContext() {
		return GameCenter.getContext();
	}
	
	/**
	 * Create the application.
	 */
	public GameCenterMenu() {
		try {
			URL gameUrl = new URL("https://raw.githubusercontent.com/Ch3di/images/main/game.png");
			setIconImage(Toolkit.getDefaultToolkit().getImage(gameUrl));
			
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		initialize();
	}

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {
		
		this.setResizable(false);
		this.setBounds(600, 200, 970, 629);
		this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JButton quit = new JButton("");
		
		try {
			URL quitUrl = new URL("https://raw.githubusercontent.com/Ch3di/images/main/quit2.png");
			quit.setIcon(new ImageIcon(quitUrl));
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		quit.setBounds(936, 0, 33, 33);
		quit.setBorderPainted(false);
		quit.setOpaque(false);
		quit.setContentAreaFilled(false);
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		
		this.getContentPane().add(quit);
		

		
		JButton sokoban = new JButton("");
		
		try {
			URL sokobanUrl = new URL("https://raw.githubusercontent.com/Ch3di/images/main/sokoban.jpg");
			sokoban.setIcon(new ImageIcon(sokobanUrl));
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		sokoban.setBorderPainted(false);
		sokoban.setOpaque(false);
		sokoban.setContentAreaFilled(false);
		sokoban.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sokobanTracker = new ServiceTracker(getContext(), SokobanGame.class.getName(), null);
				sokobanTracker.open();
				GameInterface sokobanGame = (GameInterface) sokobanTracker.getService();
				if (sokobanGame == null) {
					System.out.println("[-] Couldn't find the Sokoban Game Service.");
					System.out.println("[-] Game lauch has failed.");
				} else {
					sokobanGame.launchGame();
					System.out
							.println("[*] Sokoban Game has been launched.");
				}
			}
		});
		sokoban.setBounds(100, 220, 208, 297);
		this.getContentPane().add(sokoban);
		JButton tetris = new JButton("");
		tetris.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tetrisTracker = new ServiceTracker(getContext(), TetrisGame.class.getName(), null);
				tetrisTracker.open();
				GameInterface tetrisGame = (GameInterface) tetrisTracker.getService();
				if (tetrisGame == null) {
					System.out.println("[-] Couldn't find the Tetris Game Service.");
					System.out.println("[-] Game lauch has failed.");
				} else {
					tetrisGame.launchGame();
					System.out
							.println("[*] Tetris Game has been launched.");
				}
			}
		});
		
		try {
			URL tetrisUrl = new URL("https://raw.githubusercontent.com/Ch3di/images/main/tetris.jpg");
			tetris.setIcon(new ImageIcon(tetrisUrl));
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		tetris.setOpaque(false);
		tetris.setContentAreaFilled(false);
		tetris.setBorderPainted(false);
		tetris.setBounds(400, 220, 208, 297);
		this.getContentPane().add(tetris);
		
		JButton snake = new JButton("");
		snake.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				snakeTracker = new ServiceTracker(getContext(), SnakeGame.class.getName(), null);
				snakeTracker.open();
				GameInterface snakeGame = (GameInterface) snakeTracker.getService();
				if (snakeGame == null) {
					System.out.println("[-] Couldn't find the Snake Game Service.");
					System.out.println("[-] Game lauch has failed.");
				} else {
					snakeGame.launchGame();
					System.out
							.println("[*] snake Game has been launched.");
				}
			}
		});
		
		try {
			URL snakeUrl = new URL("https://raw.githubusercontent.com/Ch3di/images/main/snake-game.jpg");
			snake.setIcon(new ImageIcon(snakeUrl));
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		snake.setOpaque(false);
		snake.setContentAreaFilled(false);
		snake.setBorderPainted(false);
		snake.setBounds(680, 220, 208, 297);
		this.getContentPane().add(snake);
		JLabel lblNewLabel = new JLabel("");
		
		try {
			URL gameCenterUrl = new URL("https://raw.githubusercontent.com/Ch3di/images/main/game-Centers.png");
			lblNewLabel.setIcon(new ImageIcon(gameCenterUrl));
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		lblNewLabel.setBounds(0, 0, 980, 629);
		this.getContentPane().add(lblNewLabel);
		
        FrameDragListener frameDragListener = new FrameDragListener(this);
        this.addMouseListener(frameDragListener);
        this.addMouseMotionListener(frameDragListener);

//        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
	}
	
	public static class FrameDragListener extends MouseAdapter {

        private final JFrame frame;
        private Point mouseDownCompCoords = null;

        public FrameDragListener(JFrame frame) {
            this.frame = frame;
        }

        @Override
		public void mouseReleased(MouseEvent e) {
            mouseDownCompCoords = null;
        }

        @Override
		public void mousePressed(MouseEvent e) {
            mouseDownCompCoords = e.getPoint();
        }

        @Override
		public void mouseDragged(MouseEvent e) {
            Point currCoords = e.getLocationOnScreen();
            frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
        }
    }

}
