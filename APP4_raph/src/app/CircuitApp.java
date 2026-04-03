package app;

import electronique.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static app.CircuitBuiler.PathIn;

public class CircuitApp {
   public CircuitApp() {
       Path path = Path.of(
               System.getProperty("user.dir"),
               "APP4_raph",
               "src",
               "donnees.fichiers_json",
               "circuit.json"
       );

       String json = null;
       try {
           json = Files.readString(path);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }

       CircuitBuiler c = new CircuitBuiler();
       Composant comp = c.construireCircuit(json);
       System.out.println(comp.calculerResistance());
//       CircuitBuiler builer = new CircuitBuiler();
//       Composant c = builer.construireCircuit(PathIn);
//       System.out.println(c.calculerResistance());



   }

    public static void main(String[] args) {
      new CircuitApp();
    }
}
