package com.vektorel.telefonuygulamasi.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.MaskFormatter;

import com.vektorel.telefonuygulamasi.dao.DAO;
import com.vektorel.telefonuygulamasi.entity.Person;
import com.vektorel.telefonuygulamasi.entity.SorgulaEntity;
import com.vektorel.telefonuygulamasi.enums.GorusmeTipi;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sorgula extends JFrame {

	private JPanel contentPane;
	private JTextField adSoyadTF;
	private JTable table;
	private JFormattedTextField basTarihTF;
	private JFormattedTextField bitisTarTF;
	private JRadioButton tlfRD;
	private JRadioButton yuzYuzeRD;



	/**
	 * Create the frame.
	 */
	public Sorgula(DAO dao) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 403, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Ba\u015F. Tarihi");
		
		basTarihTF = new JFormattedTextField(createFormat("##-##-####"));
		
		JLabel lblBitiTarihi = new JLabel("Biti\u015F Tarihi");
		
		bitisTarTF = new JFormattedTextField(createFormat("##-##-####"));
		
		JLabel lblAdSoyad = new JLabel("Ad Soyad");
		
		adSoyadTF = new JTextField();
		adSoyadTF.setColumns(10);
		
		ButtonGroup bG = new ButtonGroup();
		
		tlfRD = new JRadioButton(GorusmeTipi.TELEFON.getValue());
		tlfRD.setSelected(true);
		
		yuzYuzeRD = new JRadioButton(GorusmeTipi.YUZ_YUZE.getValue());
		
		bG.add(tlfRD);
		bG.add(yuzYuzeRD);
		
		table = new JTable();
		
		
		JButton btnSorgula = new JButton("Sorgula");
		btnSorgula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SorgulaEntity sorgulaEntity = new SorgulaEntity();
				
				sorgulaEntity.setAdSoyad(adSoyadTF.getText());
				sorgulaEntity.setBasTarihi(basTarihTF.getText());
				sorgulaEntity.setBitisTarihi(bitisTarTF.getText());
				
				if(tlfRD.isSelected()){
					sorgulaEntity.setType(GorusmeTipi.TELEFON.getId());
				}else if(yuzYuzeRD.isSelected()){
					sorgulaEntity.setType(GorusmeTipi.YUZ_YUZE.getId());
				}
				
				List<Person> myList = dao.sorgula(sorgulaEntity);
				
				String[] columns = {"id","isim Soyad","Mesaj","Telefon"};
				String[][] rows = new String[myList.size()][4];
				for (int i = 0; i < myList.size(); i++) {
					rows[i][0]= String.valueOf(myList.get(i).getId());
					rows[i][1]= myList.get(i).getAdSoyad();
					rows[i][2]= myList.get(i).getMesaj();
					rows[i][3]= myList.get(i).getTelefon();
				}
				TableModel dataModel = new DefaultTableModel(rows, columns);
				table.setModel(dataModel);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(table, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblAdSoyad))
							.addGap(24)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(basTarihTF, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblBitiTarihi)
									.addGap(18)
									.addComponent(bitisTarTF, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
								.addComponent(adSoyadTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(tlfRD)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(yuzYuzeRD)
							.addGap(67)
							.addComponent(btnSorgula)))
					.addContainerGap(79, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(basTarihTF, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBitiTarihi)
						.addComponent(bitisTarTF, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAdSoyad)
						.addComponent(adSoyadTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(tlfRD)
						.addComponent(yuzYuzeRD)
						.addComponent(btnSorgula))
					.addGap(18)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private MaskFormatter createFormat(String value){
		MaskFormatter maskFormatter = null;
		try {
			maskFormatter = new MaskFormatter(value);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return maskFormatter;
	}
}
