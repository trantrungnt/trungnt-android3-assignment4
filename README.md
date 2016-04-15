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

+ Dùng Animation ZoomIn và ZoomOut cho ImageView ảnh: imgViewMain (có 2 cách: định nghĩa animation trong file zoomIn.zml, zoomOut.xml hoặc dùng cách code java trực tiếp). Ở đây, ta code Java trực tiếp 2 chức năng ZoomIn và ZoomOut. Tôi muốn sau khi ZoomOut hoặc ZoomIn xong thì Ảnh vẫn lưu lại và hiển thị cho người dùng. Nếu để 2 thuộc tính pivotX, pivotY thì ảnh ZoomOut hoặc ZoomIn xong thì ảnh sẽ từ từ biến mất
Với ZoomIn:
```
        zoomIn = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f);
        zoomIn.setDuration(1000);
        zoomIn.setFillAfter(true);
```
Sau đó, ta sử dụng chức năng ZoomIn với ImageView ảnh imgViewMain
```
      imgViewMain.startAnimation(zoomIn);
```

Với ZoomOut
```
        zoomOut = new ScaleAnimation(0.0f, 1.0f, 0.5f, 1.0f);
        zoomOut.setDuration(1000);
        zoomOut.setFillAfter(true);
```
Sau đó, ta sử dụng chức năng ZoomOut với ImageView ảnh imgViewMain
```
      imgViewMain.startAnimation(zoomOut);
```

+ PivotX, pivotY: định nghĩa toạ độ start của View mà ta muốn thực hiện animation. Nếu để 0 có nghĩa start từ top/left; nếu để 50% tức là start từ chính giữa. Chú ý: 50% thì là chính giữa của view, 50%p thì là chính giữa của view cha.
Cái đoạn code mà animation xong thì view biến mất là do ta đang để pivotXType và pivotType = ABSOLUTE:

Code cũ: 
```
   zoomIn = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 0);
```

Code mới:
```
   zoomIn = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

```

+ Hiện ta, do view bị cộng thêm margin của view vừa bị ẩn đi => set lại margin cho view mới 

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
+ [Layouts in Android](https://duythanhcse.wordpress.com/2013/04/01/bai-tap-7-lam-quen-voi-cac-layout-trong-android/)
