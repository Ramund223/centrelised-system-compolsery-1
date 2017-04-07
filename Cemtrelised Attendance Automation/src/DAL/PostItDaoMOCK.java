///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package DAL;
//
//import Be.PostIt;
//import javafx.scene.image.Image;
//
//
///**
// *
// * @author pgn
// */
//public class PostItDaoMOCK
//{
//
//    private static final Image[] images =
//    {
//         
//    };
//
//    private static final String[] texts =
//    {
//        "Hello world", "I'm a postIt", "Are you excited about the second semester?", "I love cake", "1 L0\\/3 j4\\/4"
//    };
//
//    private int imageCounter;
//    private int textCounter;
//
//    public PostItDaoMOCK()
//    {
//        imageCounter = 0;
//        textCounter = 0;
//    }
//
//    public PostIt getPostIt()
//    {
//        PostIt reult = new PostIt(images[imageCounter], texts[textCounter]);
//        imageCounter = ++imageCounter % images.length;
//        textCounter = ++textCounter % texts.length;
//        return reult;
//    }
//
//}
