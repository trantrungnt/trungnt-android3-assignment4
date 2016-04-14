# trungnt-android3-assignment4
##Yêu cầu
+ Tạo giao diện gồm 3 layout dạng frameLayout, mỗi layout có 1 nút x bên phải trên cùng màn hình
+ Có 2 nút: nút Show, nút HIde không bị scroll và nằm yên trong 1 vùng 
+ Khi nhấn nút đóng ở frameLayout nào thì layout đó bị đóng
+ Khi nhấn nút Show thì cả 3 frameLayout đều hiển thị
+ Khi nhấn nút Hide thì cả 3 frameLayout đều đóng

##Demo kết quả bài tập
+ [Xem tại đây](https://youtu.be/5Y-sdpwl3Bo)
+ [Bản demo đã fix lại giao diện Main và thêm 2 nút Show và Hide ở màn hình chính](https://youtu.be/8qQ1pI3r0_0)

##Chú ý khi code
+ Ta có giao diện xml có sẵn gồm: relativeLayout bao ngoài LinearLayout (dùng cho nút Show và nút Hide), 1 FrameLayout và 1 RelativeMain. Trong FrameLayout có chứa 2 Relative: relativeAuthor, relativeWork. Để tác động thay đổi giá trị MarginTop của relativeAuthor trong FrameLayout, ta làm như sau:
```
FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) relativeLayoutAuthor.getLayoutParams();
            params.topMargin = 0;
            relMain.setLayoutParams(params);
            relMain.requestLayout();
```

##Môi trường phát triển
+ Hệ điều hành Android version 4.3
+ Bộ công cụ Android Studio 2.0
+ Máy ảo Genymontion và api 18

##Tham khảo
+ [Lấy Icon trên trang web của Design Google](https://design.google.com/icons/#ic_highlight_off)
+ [Creating layout programmatically layoutparams](http://startandroid.ru/en/lessons/complete-list/220-lesson-16-creating-layout-programmatically-layoutparams.html)
+ [Android adding simple animations while setvisibilityview gone](http://stackoverflow.com/questions/22454839/android-adding-simple-animations-while-setvisibilityview-gone)
+ [Tổng hợp các cách sử dụng Amination trên 1 view ](http://android.vn/threads/tong-hop-cac-cach-su-dung-animation-tren-mot-view.25929/)
+ [slide up /down translate](http://iserveandroid.blogspot.com/2010/12/slide-up-down-translate.html)
+ [Android working with xml animation](http://www.androidhive.info/2013/06/android-working-with-xml-animations/)
+ [Android adding simple animations while set visibility view gone](https://www.codementor.io/tips/7812274333/android-adding-simple-animations-while-setvisibility-view-gone)
+ [Simple Android animation on view gone visible](https://colinyeoh.wordpress.com/2012/10/07/simple-android-animation-on-view-gonevisible/)
+ [Create relative layout programmatically android example](http://www.android-examples.com/create-relativelayout-programmatically-android-example/)
+ [Add margin programatically to relativelayout what is doing wrong](http://stackoverflow.com/questions/18844418/add-margin-programatically-to-relativelayout-what-im-doing-wrong)
