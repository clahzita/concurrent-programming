package mutex;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MainSynchronized {

  public static void main(String[] args) {
    // numero de threads ativas
    int numberOfThreads = 10;
    // guarda o somatorio de tempos para calculo da media
    long timeSum = 0;
    // numero de rodadas
    int runTotal = 20;
    // rodada inicial
    int run = 0;
    // numero de chamadas do metodo do contador
    int counterCalls = 1000;

    PrintWriter fileRecord;
    FileWriter file;

    try {
      // abertura de arquivo com resultados
      file = new FileWriter(
          "C:\\Users\\clah\\eclipse-workspace\\Atividade-Concorrente-Relatorio\\results\\mutexsynchronized.csv",
          true);
      System.out.println("Arquivo criado com sucesso.\n");
      fileRecord = new PrintWriter(file);
      fileRecord.println(numberOfThreads + ";" + runTotal + ";" + counterCalls);
    } catch (IOException e) {
      System.out.print("Não foi possivel criar o arquivo.");
      fileRecord = null;
      file = null;
    }

    while (run < runTotal) {
      // marca o inicio do tempo da rodada
      long initialTime = System.currentTimeMillis();

      // lista de threads para guardar todas que forem criadas
      final List<Thread> threads = new ArrayList<>(numberOfThreads);

      // contador com as adaptações para cada abordagem
      SynchronizedCounter counter = new SynchronizedCounter(0);

      // laço para criar as threads, executar e guardar na lista
      for (int i = 0; i < numberOfThreads; i++) {

        Runnable r = new SynchronizedThread(i, counter, counterCalls);
        Thread t = new Thread(r);
        t.start();
        threads.add(t);

      }

      // laço que espera todas as threads finalizarem
      for (final Thread thread : threads) {
        try {
          thread.join();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

      // marca o tempo final da execução
      long finalTime = System.currentTimeMillis() - initialTime;
      System.out.println("Tempo: " + finalTime + " ms");

      run++;
      if (fileRecord != null) {
        // guarda tempo final no arquivo csv
        fileRecord.println((run) + ";" + finalTime);
      }


      // acumula todos os tempos finais
      timeSum += finalTime;
    }

    // calcula a media de tempo de execução
    long media = timeSum / runTotal;

    System.out.println("media: " + media);
    if (fileRecord != null) {
      fileRecord.println("media geral: " + media);
    }

    try {
      file.close();
    } catch (IOException e) {
      System.out.print("Não foi possivel fechar o arquivo.");
      e.printStackTrace();
    }

  }
}
