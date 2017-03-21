package com.example.haams.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mainListView;
    private ArrayList<Student> stuList;
    private StudentAdapter sAdater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainListView = (ListView)findViewById(R.id.mainListView);
        stuList = new ArrayList<>();

        stuList.add(new Student("함성호","12학번"));
        stuList.add(new Student("김우영","11학번"));
        stuList.add(new Student("박종민","11학번"));
        stuList.add(new Student("한채연","16학번"));
        stuList.add(new Student("정예진","13학번"));
        stuList.add(new Student("정성일","12학번"));
        stuList.add(new Student("오지헌","11학번"));
        stuList.add(new Student("서명윤","14학번"));
        stuList.add(new Student("오은주","16학번"));
        stuList.add(new Student("노현영","14학번"));
        stuList.add(new Student("김나경","16학번"));
        stuList.add(new Student("최다힘","14학번"));
        stuList.add(new Student("조인영","13학번"));



        sAdater = new StudentAdapter(stuList,MainActivity.this);

        mainListView.setAdapter(sAdater);

    }
}
