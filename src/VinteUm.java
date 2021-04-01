import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class VinteUm {

	public static void main(String[] args) {
		System.out.println("********************************************");
		System.out.println("***********BEM VINDO - VINTE E UM***********");
		System.out.println("********************************************\n");
		System.out.println("\t\tSEU TURNO\n");
		Scanner sc = new Scanner(System.in);
		int pontuacao = 0;
		int pontuacaoMaquina = 0;
		Character continuar = 's';
		int naipe = 0;
		String cartas[][] = new String[][] {
				{ "A\u2660", "2\u2660", "3\u2660", "4\u2660", "5\u2660", "6\u2660", "7\u2660", "8\u2660", "9\u2660",
						"J\u2660", "Q\u2660", "K\u2660" },
				{ "A\u2663", "2\u2663", "3\u2663", "4\u2663", "5\u2663", "6\u2663", "7\u2663", "8\u2663", "9\u2663",
						"J\u2663", "Q\u2663", "K\u2663" },
				{ "A\u2665", "2\u2665", "3\u2665", "4\u2665", "5\u2665", "6\u2665", "7\u2665", "8\u2665", "9\u2665",
						"J\u2665", "Q\u2665", "K\u2665" },
				{ "A\u2666", "2\u2666", "3\u2666", "4\u2666", "5\u2666", "6\u2666", "7\u2666", "8\u2666", "9\u2666",
						"J\u2666", "Q\u2666", "K\u2666" } };
		int cartaAtual;
		int vetorControle[] = new int[52];
		int cont = 0;

		do {
			cartaAtual = pegarCarta();

			if (vetorControle[cartaAtual] != 99) {
				vetorControle[cartaAtual] = 99;
				naipe = (int) (cartaAtual / 13);
				int conversao = cartaAtual % 12;
				if (conversao >= 10) {
					pontuacao += 10;
				} else {
					pontuacao += conversao + 1;
				}
				System.out.println(
						"Você tirou a carta " + cartas[naipe][cartaAtual % 12] + " - Pontuação atual: " + pontuacao);
				if (pontuacao >= 21) {
					System.out.println("QUE PENA \u2639\u2639\u2639\u2639 \nVoce Perdeu. ");
					return;
				}
				System.out.println("Deseja pegar uma carta?(s/n)");
				continuar = sc.next().charAt(0);
			}

		} while (pontuacao < 21 && (continuar == 's'));

		do {
			cartaAtual = pegarCarta();

			if (vetorControle[cartaAtual] != 99) {
				cont++;
				vetorControle[cartaAtual] = 99;
				naipe = (int) (cartaAtual / 13);
				int conversao = cartaAtual % 12;
				if (conversao >= 10) {
					pontuacaoMaquina += 10;
				} else {
					pontuacaoMaquina += conversao + 1;
				}
				System.out.println("A máquina tirou a carta " + cartas[naipe][cartaAtual % 12] + " - Pontuação atual: "
						+ pontuacaoMaquina);
				if (pontuacaoMaquina > 21) {
					System.out.println("PARABÉNS!!! \nVoce Venceu \u263A ");
					return;
				}
			}

		} while (pontuacaoMaquina < 18 && cont < 4);

		if (pontuacao > pontuacaoMaquina) {
			System.out.println("PARABÉNS!!! \nVoce Venceu \u263A ");
		} else if (pontuacao == pontuacaoMaquina) {
			System.out.println("EMPATE!! \u263A \u2639");
		} else {
			System.out.println("QUE PENA \u2639\u2639\u2639\u2639 \nVoce Perdeu. ");
		}
	}

	public static int pegarCarta() {
		BigDecimal bd = new BigDecimal((Math.random() * 52)).setScale(0, RoundingMode.HALF_EVEN);
		return (bd.intValue());
	}
}