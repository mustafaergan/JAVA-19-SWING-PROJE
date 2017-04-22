package com.vektorel.telefonuygulamasi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.vektorel.telefonuygulamasi.dao.DAO;
import com.vektorel.telefonuygulamasi.entity.Person;
import com.vektorel.telefonuygulamasi.enums.GorusmeTipi;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class GenelGorusme extends JFrame {

	private JPanel contentPane;
	private JTextField adiSoyadiTF;
	private JTextField telefonTF;
	private JRadioButton secimYuzYuzeRD;
	private JRadioButton secimTelefonRD ;
	private JLabel lblMesaj;
	private JTextArea mesajTA;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GenelGorusme frame = new GenelGorusme();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public GenelGorusme(DAO dao) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 271, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAdSoyad = new JLabel("Ad\u0131 Soyad\u0131");
		
		JLabel lblTefonunu = new JLabel("Tefonunu");
		
		adiSoyadiTF = new JTextField();
		adiSoyadiTF.setColumns(10);
		
		telefonTF = new JTextField();
		telefonTF.setColumns(10);
		
		ButtonGroup bG = new ButtonGroup();
		
		secimTelefonRD = new JRadioButton(GorusmeTipi.TELEFON.getValue());
		secimTelefonRD.setSelected(true);
		
		secimYuzYuzeRD = new JRadioButton(GorusmeTipi.YUZ_YUZE.getValue());
		
		bG.add(secimTelefonRD);
		bG.add(secimYuzYuzeRD);

		
		lblMesaj = new JLabel("Mesaj");
		
		mesajTA = new JTextArea();
		mesajTA.setColumns(20);
		mesajTA.setRows(20);
		
		JButton btnNewButton = new JButton("Kay\u0131t Et");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Person person = new Person();
				person.setAdSoyad(adiSoyadiTF.getText());
				person.setTelefon(telefonTF.getText());
				person.setMesaj(mesajTA.getText());
				if(secimTelefonRD.isSelected()){
					person.setGorusmeTipi(GorusmeTipi.TELEFON.getId());
				}else if(secimYuzYuzeRD.isSelected()){
					person.setGorusmeTipi(GorusmeTipi.YUZ_YUZE.getId());
				}
				person.setGorusmeZamani(Calendar.getInstance().getTime());
				
				dao.addValue(person);
				
				setVisible(false);
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAdSoyad)
						.addComponent(lblTefonunu)
						.addComponent(secimTelefonRD)
						.addComponent(lblMesaj))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(secimYuzYuzeRD)
						.addComponent(adiSoyadiTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(mesajTA, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
							.addComponent(telefonTF, Alignment.LEADING)
							.addComponent(btnNewButton)))
					.addContainerGap(218, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(adiSoyadiTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAdSoyad))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTefonunu)
						.addComponent(telefonTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(secimYuzYuzeRD)
						.addComponent(secimTelefonRD))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addComponent(lblMesaj))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(mesajTA, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
					.addComponent(btnNewButton))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
