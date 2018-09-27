package purevolatilevariable;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MainVolatile {

  public static void main(String[] args) {
    int numberOfThreads = 100;
    long timeSum = 0;
    int runTotal = 20;
    int run = 0;
    int counterCalls = 1000;
    
    PrintWriter fileRecord;
    FileWriter file;
    
    try {
      file = new FileWriter("C:\\Users\\clah\\eclipse-workspace\\Atividade-Concorrente-Relatorio\\results\\volatilevariable.csv", true);
      System.out.println("Arquivo criado com sucesso.\n");
      fileRecord = new PrintWriter(file);
      fileRecord.println(numberOfThreads+";"+runTotal+";"+counterCalls);
    } catch (IOException e) {
      System.out.print("Não foi possivel criar o arquivo.");
      fileRecord = null;
      file = null;
    }

    while (run < runTotal) {
     
      long initialTime = System.currentTimeMillis();
      
      final List<Thread> threads = new ArrayList<>(numberOfThreads);
      
      VolatileCounter counter = new VolatileCounter(0);

      for (int i = 0; i < numberOfThreads; i++) {

        Runnable r = new VolatileThread(i, counter, counterCalls);
        Thread t = new Thread(r);
        t.start();
        threads.add(t);

      }

      for (final Thread thread : threads) {
        try {
          thread.join();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      
      long finalTime = System.currentTimeMillis() - initialTime;
      System.out.println("Tempo: " + finalTime + " ms");
      
      run++;
      if(fileRecord != null) {
        fileRecord.println((run)+";"+finalTime);
      }
       
    

      timeSum += finalTime;
    }

    long media = timeSum / runTotal;
    
    System.out.println("media: " + media);
    if(fileRecord != null) {
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
