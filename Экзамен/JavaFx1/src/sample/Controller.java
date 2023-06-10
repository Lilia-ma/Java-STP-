package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Controller {
    // C:\Users\mpaпаваpa\IdeaProjects\JavaFxSrFile\src\files\myfile.txt
    @FXML
    TextField res_fld;
    @FXML
    TextField path_fld;


    public double getAverage(File file){
        Scanner scanner = null;
        ArrayList<Double> arrayList = new ArrayList<>();
        try{
            scanner = new Scanner(file);
            while (scanner.hasNext()){
                try{
                    double x = scanner.nextInt();
                    arrayList.add(x);
                }
                catch (InputMismatchException exception){
                    Alert alert = new Alert(Alert.AlertType.ERROR,"Возникла ошибка чтения файла!");
                    alert.showAndWait();
                    return -1;
                }
            }
            double lengthOfArray = arrayList.size();
            double sum = 0;
            if (lengthOfArray > 0){
                for (Double d : arrayList){
                    sum += d;
                }
                return sum/lengthOfArray;
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR,"Не нашлось чисел!");
                alert.showAndWait();
                return -1;
            }
        }
        catch (FileNotFoundException exception){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Файл не найден!");
            alert.showAndWait();
            return -1;
        }
    }

    @FXML
    public void clickMe(){
        res_fld.clear();
        File file = new File(path_fld.getText());
        if (file.isFile()){
            double result = getAverage(file);
            if (result == -1){
                Alert alert = new Alert(Alert.AlertType.ERROR,"Так как возникла ошибка, вы не получите ответа!");
                alert.showAndWait();
            }
            else {
                res_fld.setText("Ответ: " + result);
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Вы допустили ошибку!");
            alert.showAndWait();
        }
        path_fld.clear();
    }
}
