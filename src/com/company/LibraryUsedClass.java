package com.company;

@Controller
public class LibraryUsedClass extends TestLibrary {

    @StartMetod(msg = "Старт через анатацию")
    public void run(String msg){
        System.out.println(msg);
    }

    @Test
    public void Testirovanie(){
        System.out.println("Запускаем некие тесты");
    }

}
