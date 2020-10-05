package main;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Font;

/**
 *  
 * @author Daniel Busarello
 * @version 1.0.0
 *
 **/ 

public class View {

	private JFrame frame;
	private JTable tbMatches;
	private JTextField tfScore;
	
	DefaultTableModel model;
	
	Season s = new Season();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public View() throws Exception {
		initialize();
	}

	private void initialize() throws Exception {
		frame = new JFrame();
		frame.setBounds(100, 100, 665, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 630, 339);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Jogos", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrPnMatchTb = new JScrollPane();
		scrPnMatchTb.setBounds(10, 40, 605, 140);
		panel.add(scrPnMatchTb);
		
		// Create the table columns with their labels
		model = new DefaultTableModel();
		
		Object[] column = { "Jogo", "Placar", "Mín. tempordada", "Máx. tempordada", "Recorde mín.", "Recorde máx." };
		Object[] row = new Object[6];
		
		model.setColumnIdentifiers(column);

		tbMatches = new JTable();
		scrPnMatchTb.setViewportView(tbMatches);
		tbMatches.setModel(model);
		// End table
		
		JPanel pnNewGame = new JPanel();
		pnNewGame.setBounds(10, 230, 605, 78);
		pnNewGame.setBorder(new TitledBorder(null, "Novo jogo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(pnNewGame);
		pnNewGame.setLayout(null);
		
		JLabel lblScore = new JLabel("Placar");
		lblScore.setBounds(10, 29, 46, 14);
		pnNewGame.add(lblScore);
		
		tfScore = new JTextField();
		tfScore.setBounds(66, 26, 86, 20);
		pnNewGame.add(tfScore);
		tfScore.setColumns(10);
		
		// Set the values of columns and add a new row
		JButton btnAddMatch = new JButton("Adicionar");
		btnAddMatch.setBounds(20, 191, 89, 23);
		btnAddMatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Game g = new Game(Integer.parseInt(tfScore.getText()));
					s.addNewGame(g);
					row[0] = s.getMatches().indexOf(g) + 1;
					row[1] = g.getScore();
					row[2] = s.getMinScore();
					row[3] = s.getMaxScore();
					row[4] = s.getMinRecordCount();
					row[5] = s.getMaxRecordCount();
					model.addRow(row);
				} catch(IllegalArgumentException e) {
					JOptionPane.showMessageDialog(tabbedPane, e.getMessage());
				} catch(Exception e) {
					JOptionPane.showMessageDialog(tabbedPane, "Insira um valor numérico positivo no placar para adicionar um novo jogo!");
				}
			}
		});
		panel.add(btnAddMatch);
		
		JLabel lblTitle = new JLabel("Jogos da temporada");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 11, 119, 14);
		panel.add(lblTitle);
	}
}

