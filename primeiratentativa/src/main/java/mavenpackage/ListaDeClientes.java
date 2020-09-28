package mavenpackage;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class ListaDeClientes extends JFrame {
	
	private DefaultTableModel table = new DefaultTableModel();
	private JTable tabela;
	private JScrollPane scroll;
	private JPanel fundo;
	
	public ListaDeClientes() {
		super("Clientes");
		criaJTable();
	}
	private void criaJTable() {
		
		table.addColumn("ID");
		table.addColumn("Nome");
		table.addColumn("CPF");
		
		table.setNumRows(0);
		
		ClienteDAO dao = new ClienteDAO();
		for(Clientes c : dao.getListaClientes()) {
			table.addRow(
					new Object[] {
							c.getId(),
							c.getNome(),
							c.getCpf()
					});
		}
		
		tabela = new JTable(table);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(180);
	}
	
	public void criaJanela() {
		
		scroll = new JScrollPane(tabela);
		fundo = new JPanel();
		fundo.setLayout(new BorderLayout());
		fundo.add(BorderLayout.CENTER, scroll);
		getContentPane().add(fundo);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 320);
		setVisible(true);
	}
}
