# LazyFinder

Are you lazy as me? Bored to write findViewById() everytime, when you want find and use a View? Here is an easy solution for you. I know there are @annotation based solutions already, so what is the difference with LazyFinder then? Well you have to write only ONE line of code, nothing more. There is only one rule: you have to name the View's @+id and field name to the same.

## How it works


Lets say you have a layout like this for an Activity:

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    >

    <Button
        android:id="@+id/button1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Activity"/>

    <Button
        android:id="@+id/button2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Fragment"/>

</LinearLayout>
```
Then you have to add ONE line of code to find both buttons.

```
public class MainActivity extends AppCompatActivity{

    private Button test1 = null;
    private Button test2 = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        LazyFinder.findAll(this);
        
        //do what you want with your views
    }
}
```
If works for more views as well, you can find views in a fragment or in a custom view too:

```
LazyFinder.findAll(context, this, view);

context:	like getActivity()
this:		the fragment
view:		the fragment's view
```

How about inheritance? It can find parent class views as well! Lets say you have a parent activity:

```
public class Parent extends AppCompatActivity{

    protected TextView text4;

}
```

And you have an activity which inherits from it:

```
public class ChildActivity extends Parent{

    private TextView text1 = null;
    private TextView text2 = null;
    private TextView text3 = null;
    private TextView text5 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);
        LazyFinder.findAll(this, 2);
        
        //do what you want with your views and you can use 'text4' view too from the parent 			activity
    }

}
```
In this case you need to define a deepness, so LazyFinder can go and check parent classes too, to find views. In this example deepness is 2, but you can go deeper if you want to or need to.


## Working with ProGuard
Well if you a fan of using ProGuard then you need add this to the proguard-rules.pro file:

```
-keepclassmembers class * {
    private <fields>;
    public <fields>;
    protected <fields>;
    !public !protected !private <fields>;
}
```
Proguard will mess up field names, so finding will not work, because field name will not equal to @+id name. 

## Requirements
Android api 4.3+.

Add to dependencies:
```
compile 'com.github.gerp83:LazyFinder:1.00'
```
  
## Examples
You can find working examples in the demo folder.

## Lisence
```
DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE 
Version 2, December 2004 

Copyright (C) 2017 GErP83 <gurrka@gmail.com> 

Everyone is permitted to copy and distribute verbatim or modified 
copies of this license document, and changing it is allowed as long 
as the name is changed. 

DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE 
TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION 
0. You just DO WHAT THE FUCK YOU WANT TO.
```
[wtfpl](http://www.wtfpl.net/)

I hope this can make your job easier, happy finding!
