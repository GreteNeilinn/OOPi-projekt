import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.print.DocFlavor;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Gui_rühmatöö extends Application {


    @Override
    public void start(Stage peaLava) {
        Group juur = new Group(); // luuakse juur
        Text tervitus = new Text("Tere tulemast Sinu treeningpäevikusse!");
        tervitus.setFont(Font.font("Sans serif", FontWeight.BOLD, FontPosture.REGULAR, 25));
        Text juhend = new Text(" Programmi kasutamine on suhteliselt lihtne! Treeningu sisesta- \nmiseks sisesta allolevasse kasti oma treeningu andmed kujul \n\"kuupäev; kestusMinutites; sinuKaal\". \nKuupäeva sisestada nii: aaaa-kk-pp.\nVarasemate treeningute vaatamiseks kliki vastaval nupul.");
        juhend.setFont(Font.font("Sans serif", FontWeight.NORMAL, FontPosture.REGULAR, 14));

        ObservableList<String> spordialad = FXCollections.observableArrayList(
                "Aeglane hüpits", "Golf", "Hüpits", "Jalgpall", "Jooks", "Kiire hüpits", "Korvpall", "Pikamaajooks", "Võrkpall", "Ujumine");
        final ChoiceBox spordialaValik = new ChoiceBox(spordialad);
        Button nuppSisesta = new Button("Sisesta treening");
        Button nuppVaata = new Button("Vaata treeninguid");
        Button nuppSisestaVeel = new Button("Sisesta järgmine treening");
        TextField treeninguSisestus = new TextField();

        nuppSisesta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String treening = treeninguSisestus.getText();
                try {
                    sisestaFaili(treening, spordialaValik.getValue());
                } catch (IOException e) {
                    System.out.println("ioviga");
                }
                System.out.println(treening);
                treeninguSisestus.clear();
                spordialaValik.getSelectionModel().clearSelection();
                treeninguSisestus.setText("Treening sisestatud!");
            }

            private void sisestaFaili(String treening, Object sport) throws IOException {
                try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("treeningud.txt", true), "UTF-8"))) {
                    if (treening.split("; ").length != 3)
                        throw new SisestusvormiVigaErind("Valesti sisestatud");
                    else {
                        bw.append(String.valueOf(sport));
                        bw.append("; ");
                        bw.append(treening);
                        bw.newLine();
                    }
                } catch (SisestusvormiVigaErind sisestusvormiVigaErind) {
                    treeninguSisestus.setText("Sisesta korrektne treening!");
                }
            }
        });
        nuppVaata.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final Stage dialog = new Stage();
                dialog.initModality(Modality.APPLICATION_MODAL);
                dialog.initOwner(peaLava);
                VBox dialogVbox = new VBox(20);
                HBox dialogHbox = new HBox(20);
                dialogHbox.getChildren().add(new Text("      "));
                dialogHbox.getChildren().add(new Text("Spordiala"));
                dialogHbox.getChildren().add(new Text("      Kuupäev      "));
                dialogHbox.getChildren().add(new Text("Kestus minutites"));
                dialogHbox.getChildren().add(new Text("Põletatud kalorid"));
                dialogVbox.getChildren().add(dialogHbox);
                try {
                    dialogVbox.getChildren().add(new Text(loeFailist("treeningud.txt")));
                } catch (IOException e) {
                    System.out.println("Faili ei leita.");
                }
                Scene dialogScene = new Scene(dialogVbox, 450, 500);
                dialog.setScene(dialogScene);
                dialog.show();
            }

            private String loeFailist(String failinimi) throws IOException {
                List<Spordialad> sisestused = new ArrayList<>();
                StringBuilder sb = new StringBuilder();
                List<String> treeningud = new ArrayList<>();
                try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("treeningud.txt"), StandardCharsets.UTF_8))) {
                    String rida = br.readLine();
                    while (rida != null) {
                        String[] ridaTükeldatud = rida.split("; ");
                        treeningud.add(ridaTükeldatud[0]);
                        if (ridaTükeldatud[0].equals("Aeglane hüpits")) {
                            sisestused.add(new AeglaneHüpits(ridaTükeldatud[1], Integer.parseInt(ridaTükeldatud[2]), Integer.parseInt(ridaTükeldatud[3])));

                        } else if (ridaTükeldatud[0].equals("Golf")) {
                            sisestused.add(new Golf(ridaTükeldatud[1], Integer.parseInt(ridaTükeldatud[2]), Integer.parseInt(ridaTükeldatud[3])));

                        } else if (ridaTükeldatud[0].equals("Hüpits")) {
                            sisestused.add(new Hüpits(ridaTükeldatud[1], Integer.parseInt(ridaTükeldatud[2]), Integer.parseInt(ridaTükeldatud[3])));

                        }else if (ridaTükeldatud[0].equals("Ujumine")) {
                            sisestused.add(new Ujumine(ridaTükeldatud[1], Integer.parseInt(ridaTükeldatud[2]), Integer.parseInt(ridaTükeldatud[3])));

                        }else if (ridaTükeldatud[0].equals("Jalgpall")) {
                            sisestused.add(new Jalgpall(ridaTükeldatud[1], Integer.parseInt(ridaTükeldatud[2]), Integer.parseInt(ridaTükeldatud[3])));

                        } else if (ridaTükeldatud[0].equals("Jooks")) {
                            sisestused.add(new Jooksualad(ridaTükeldatud[1], Integer.parseInt(ridaTükeldatud[2]), Integer.parseInt(ridaTükeldatud[3])));

                        } else if (ridaTükeldatud[0].equals("Kiire hüpits")) {
                            sisestused.add(new Kiirehüpits(ridaTükeldatud[1], Integer.parseInt(ridaTükeldatud[2]), Integer.parseInt(ridaTükeldatud[3])));

                        } else if (ridaTükeldatud[0].equals("Pikamaajooks")) {
                            sisestused.add(new Pikamaajooks(ridaTükeldatud[1], Integer.parseInt(ridaTükeldatud[2]), Integer.parseInt(ridaTükeldatud[3])));

                        } else if (ridaTükeldatud[0].equals("Korvpall")) {
                            sisestused.add(new Korvpall(ridaTükeldatud[1], Integer.parseInt(ridaTükeldatud[2]), Integer.parseInt(ridaTükeldatud[3])));

                        } else if (ridaTükeldatud[0].equals("Võrkpall")) {
                            sisestused.add(new Võrkpall(ridaTükeldatud[1], Integer.parseInt(ridaTükeldatud[2]), Integer.parseInt(ridaTükeldatud[3])));

                        }
                        rida = br.readLine();
                    }
                }
                int i = 0;
                for (Spordialad spordialad1 : sisestused) {
                    StringBuilder vahe = new StringBuilder();
                    int ruumi = (21-treeningud.get(i).length());
                    for (int j = 0; j < ruumi; j++) {
                        vahe.append(" ");
                    }
                    sb.append("            "+ treeningud.get(i) + vahe + spordialad1 + "\n");
                    i += 1;
                }

                return sb.toString();
            }

        });
        nuppSisestaVeel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                treeninguSisestus.clear();
            }
        });

        tervitus.setLayoutX(23);
        tervitus.setLayoutY(80);
        juhend.setLayoutX(50);
        juhend.setLayoutY(120);
        spordialaValik.setLayoutX(200);
        spordialaValik.setLayoutY(260);
        treeninguSisestus.setLayoutY(300);
        treeninguSisestus.setLayoutX(180);
        nuppSisestaVeel.setLayoutX(180);
        nuppSisestaVeel.setLayoutY(390);
        nuppVaata.setLayoutX(265);
        nuppVaata.setLayoutY(350);
        nuppSisesta.setLayoutY(350);
        nuppSisesta.setLayoutX(140);
        juur.getChildren().add(spordialaValik);
        juur.getChildren().add(juhend);
        juur.getChildren().add(tervitus);
        juur.getChildren().add(nuppSisestaVeel);
        juur.getChildren().add(treeninguSisestus);
        juur.getChildren().add(nuppVaata);
        juur.getChildren().add(nuppSisesta);  // nupp lisatakse juure alluvaks
        Scene stseen1 = new Scene(juur, 505, 500, Color.GRAY);  // luuakse stseen
        peaLava.setResizable(false);
        peaLava.setTitle("Treeningpäevik");  // lava tiitelribale pannakse tekst
        peaLava.setScene(stseen1);  // lavale lisatakse stseen
        peaLava.show();  // lava tehakse nähtavaks
    }

    public static void main(String[] args) {
        launch(args);
    }

}
