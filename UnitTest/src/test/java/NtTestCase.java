
import com.mycompany.unittest.Utils;
import java.time.Duration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HIEN
 */
public class NtTestCase {
    @BeforeAll
    public static void beforeAll(){
        System.out.println("BEFORE ALL");
    }
    
    @AfterAll
    public static void afterAll(){
        System.out.println("AFTER ALL");
    }
    
    @BeforeEach
    public void beforeEach(){
        System.out.println("BEFORE EACH");
    }
    
    @AfterEach
    public void afterEach(){
        System.out.println("AFTER EACH");
    }
    
    @Test
    @DisplayName("Kiem tra so nguyen to chan")
    public void test01(){
        int n = 2;
        boolean expected = true;
        boolean actual = Utils.ktNt(n);
        
        Assertions.assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Kiem tra so nguyen to le")
    public void test02(){
        int n = 5;
        boolean actual = Utils.ktNt(n);
        
        Assertions.assertTrue(actual);
    }
    
    @Test
    public void test03(){
        Assertions.assertThrows(ArithmeticException.class, () ->{
            Utils.ktNt(-5);
        });
    }
    
    @Test
    public void test04(){
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            Utils.ktNt(6);
        });
    }
    
    @ParameterizedTest
    @ValueSource(ints = {2, 5, 7, 97, 103})
    public void testNguyenTo(int n){
        Assertions.assertTrue(Utils.ktNt(n), "hihi");
    }
    
    @ParameterizedTest
    @CsvSource({"1,false,fdf", "99,false,iff", "97,true,hij"})
    public void testAll(int n, boolean expected, String msg){
        Assertions.assertEquals(expected, Utils.ktNt(n), msg);
    }
    
    @ParameterizedTest
    @CsvFileSource(files = "src/main/resources/data.csv", numLinesToSkip=0)
    public void testAllInFile(int n, boolean expected, String msg){
        Assertions.assertEquals(expected, Utils.ktNt(n), msg);
    }
}
