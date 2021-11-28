package chapter_14_1_1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

import java.lang.reflect.InvocationTargetException;

import static org.hamcrest.CoreMatchers.*;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class CommonLangTest {
    
    @Test
    public void CommonLangMethodTest(){


        String sample = null;

        // 通常はNullチェックとLengthチェックをしないと、Empty判定はできない
        assertEquals(true, ((sample == null) && (sample.length() == 0)));

        // CommonLang の StringUtilsであれば、isEmptyでチェックできる
        assertEquals(true, StringUtils.isEmpty(sample));
    }

    @Test
    public void HashEqualMethodTest(){
        Student student1 = new Student();
        student1.setNo(1);
        student1.setName("Kazuya");
        student1.setAge(34);

        Student student2 = new Student();
        student2.setNo(2);
        student2.setName("hitomi");
        student2.setAge(33);

        Student student3 = new Student();
        student3.setNo(1);
        student3.setName("Kazuya");
        student3.setAge(34);


        assertThat(student1, is(not(student2)));
        assertThat(student1, is(student3));

    }

    @Test
    public void CopyProperiesTest() throws IllegalAccessException, InvocationTargetException{

        Student student1 = new Student();
        student1.setNo(1);
        student1.setName("Kazuya");
        student1.setAge(34);

        Student student2 = new Student(student1);

        assertThat(student1, is(student2));
    }

    @Test
    public void ShallowCopyTest() {
        Student student1 = new Student();
        student1.setNo(1);
        student1.setName("Kazuya");
        student1.setAge(34);

        // 参照を変数に代入するだけ
        Student student2 = student1;
        student2.setAge(33);

        // Student1の変数を変更している
        // これが参照のコピー、ShallowCopy
        assertEquals(33, student1.getAge());


    }
}
