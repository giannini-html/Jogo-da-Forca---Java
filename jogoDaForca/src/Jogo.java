

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Jogo extends JFrame{
	
	private JLabel lblTitulo, lblImg, lblResultado;
	private JButton btnStart;
	
	Icon imagem[];
	
	public Jogo() {
		
		lblTitulo = new JLabel("Jogo da Forca");
		lblTitulo.setBounds(300, 10, 500, 50);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 40));
		add(lblTitulo);
		
		imagem = new ImageIcon[8];
		imagem[0] = new ImageIcon("C:\\Users\\gusta\\OneDrive\\Área de Trabalho\\exercicios-si\\01\\imagens\\enforcado01.png");
		imagem[1] = new ImageIcon("C:\\Users\\gusta\\OneDrive\\Área de Trabalho\\exercicios-si\\01\\imagens\\enforcado02.png");
		imagem[2] = new ImageIcon("C:\\Users\\gusta\\OneDrive\\Área de Trabalho\\exercicios-si\\01\\imagens\\enforcado03.png");
		imagem[3] = new ImageIcon("C:\\Users\\gusta\\OneDrive\\Área de Trabalho\\exercicios-si\\01\\imagens\\enforcado04.png");
		imagem[4] = new ImageIcon("C:\\Users\\gusta\\OneDrive\\Área de Trabalho\\exercicios-si\\01\\imagens\\enforcado05.png");
		imagem[5] = new ImageIcon("C:\\Users\\gusta\\OneDrive\\Área de Trabalho\\exercicios-si\\01\\imagens\\enforcado06.png");
		imagem[6] = new ImageIcon("C:\\Users\\gusta\\OneDrive\\Área de Trabalho\\exercicios-si\\01\\imagens\\enforcado07.png");
		imagem[7] = new ImageIcon("C:\\Users\\gusta\\OneDrive\\Área de Trabalho\\exercicios-si\\01\\imagens\\enforcado08.png");

		lblImg = new JLabel(imagem[0]);
		lblImg.setBounds(50, 100, 300, 500);
		add(lblImg);
		
		lblResultado = new JLabel("");
		lblResultado.setBounds(350, 150, 500, 50);
		lblResultado.setFont(new Font("Arial", Font.BOLD, 40));
		add(lblResultado);
		
		btnStart = new JButton("Iniciar Jogo");
		btnStart.setBounds(550, 260, 250, 50);
		btnStart.setFont(new Font("Arial", Font.BOLD, 38));
		add(btnStart);
		btnStart.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						startGame();
					}
				}
		);
	}
	
	public static void main(String[] args) {
		
		Jogo form = new Jogo();
		form.setLayout(null);
		form.setBounds(0, 0, 900, 700);
		form.setLocationRelativeTo(null);
		form.setVisible(true);
		form.setResizable(false);
		form.setDefaultCloseOperation(EXIT_ON_CLOSE);
		form.setTitle("Jogo da Forca");
	}
	
	private void startGame() {
		String[] palavras = {"carro", "cachorro", "borboleta", "cavalo", "helicoptero", "moto",
					"jupter", "saturno", "brasil", "predio"};
	
		lblImg.setIcon(imagem[0]);
		
		Random gerador = new Random(new Random().nextLong());
		
		int index = gerador.nextInt(palavras.length);
		
		String palavraSelecionada = palavras[index];
		
		char[] traco = new char[(palavraSelecionada.length())];
		
		for(int i =0; i < palavraSelecionada.length(); i++) {
			traco[i] = '_';
		}
		
		int palavraString = palavras[index].length();
		int tentativas = 7, indexImagem = 1;
		
		while (palavraString > 0 && tentativas > 0) {
			
			lblResultado.setText("");
			
			for (int i = 0; i < palavraSelecionada.length(); i++) {
					lblResultado.setText(lblResultado.getText() + " " + traco[i] + " ");
				}
			
			String mensagem = "";
			mensagem += "Você tem " + tentativas + " chances de adivinhar/n";
			mensagem += "A palavra tem " + palavraString + " letras restantes/n";
			mensagem += "Digite uma letra: /n";
			
			String letra = JOptionPane.showInputDialog(null, mensagem);

			char letras = letra.charAt(0);
			
			boolean acertou = false;
			
			for (int i = 0; i < traco.length; i++) {
					if(palavras[index].charAt(i) == letras) {
						traco[i] = letras;
						palavraString--;
						acertou = true;
					}
				}
			if (!acertou) {
				
				tentativas--;
				lblImg.setIcon(imagem[indexImagem++]);
			}			
		}
		
		if (palavraString == 0) {
			lblResultado.setText(palavraSelecionada);
			
			JOptionPane.showMessageDialog(null, "Parabens!/n Você acertou! /nA palavra era: " + palavraSelecionada);
		} else {
			JOptionPane.showMessageDialog(null, "Infelizmente Você Perdeu /n/nA palavra era: " + palavraSelecionada);
		}
		
	}
}