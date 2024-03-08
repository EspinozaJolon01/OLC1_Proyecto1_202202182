/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class imgGraficas {
    
    private static ArrayList<String> imagePaths = new ArrayList<>();
    private static int currentIndex = 0;

        public static void addImagePath(String path) {
            imagePaths.add(path);
        }

        public static ArrayList<String> getImagePaths() {
            return imagePaths;
        }

        public static String getCurrentImagePath() {
            if (!imagePaths.isEmpty() && currentIndex >= 0 && currentIndex < imagePaths.size()) {
                return imagePaths.get(currentIndex);
            }
            return null;
        }

        public static void moveNext() {
            if (!imagePaths.isEmpty() && currentIndex < imagePaths.size() - 1) {
                currentIndex++;
            }
        }

        public static void movePrevious() {
            if (!imagePaths.isEmpty() && currentIndex > 0) {
                currentIndex--;
            }
        }
    
}
