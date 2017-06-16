"# StartBar" 
</br>
1.显示评分</br>
2.可评分 </br>
 <TextView </br>
        android:padding="10px"</br>
        android:layout_width="wrap_content"</br>
        android:layout_height="wrap_content"</br>
        android:text="带分数" /></br>
    <com.rongke.mifan.starbarapplication.StartBar</br>
        android:layout_margin="20px"</br>
        android:gravity="center_vertical"</br>
        app:is_need_score="true"</br>
        app:star_height="50"</br>
        android:id="@+id/sb_have_score"</br>
        android:layout_width="wrap_content"</br>
        android:layout_height="wrap_content"/></br>

         StartBar sb_have_score = (StartBar) findViewById(R.id.sb_have_score);
         sb_have_score.setCore(3);

![image](https://github.com/tzz2015/StartBar/blob/master/file/Screenshot_2017-06-16-11-11-18-496_com.rongke.mif.png)