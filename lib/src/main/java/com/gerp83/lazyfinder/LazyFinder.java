package com.gerp83.lazyfinder;
import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * a class that can find views in an Activity, Fragment or custom Class with findViewById automatically
 */
public class LazyFinder {

    /**
     * find all fields in a class with field name
     *
     * @param context Context
     * @param object the object to search fields
     * @param view the view to find all field with findViewById(id)
     */
    public static void findAll(Context context, Object object, View view) {
        findAll(context, object, view, 1);
    }

    /**
     * find all fields in a class with field name. This search can find fields in the superclasses as well.
     *
     * @param context Context
     * @param object the object to search fields
     * @param view the view to find all field with findViewById(id)
     * @param deepness search deepness
     */
    public static void findAll(Context context, Object object, View view, int deepness) {
        if (context == null || object == null || view == null) {
            return;
        }
        try {
            Field[] fields;
            if (deepness != 1) {
                fields = getSuperClassFields(object, deepness);
            } else {
                fields = object.getClass().getDeclaredFields();
            }
            for (Field field : fields) {
                Class classType = field.getType();
                if (View.class.isAssignableFrom(classType)) {
                    field.setAccessible(true);
                    field.set(object, view.findViewById(getId(field.getName(), context)));
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    /**
     * find all fields in a fragment with field name
     *
     * @param context Context
     * @param fragment Fragment
     * @param view the view to find all field with findViewById(id)
     */
    public static void findAll(Context context, Fragment fragment, View view) {
        findAll(context, fragment, view, 1);
    }

    /**
     * find all fields in a fragment with field name. This search can find fields in the superclasses as well.
     *
     * @param context Context
     * @param fragment Fragment
     * @param view the view to find all field with findViewById(id)
     * @param deepness if serach is needed in the superclasses as well
     */
    public static void findAll(Context context, Fragment fragment, View view, int deepness) {
        if (context == null || fragment == null || view == null) {
            return;
        }
        try {
            Field[] fields;
            if (deepness != 1) {
                fields = getSuperClassFields(fragment, deepness);
            } else {
                fields = fragment.getClass().getDeclaredFields();
            }
            for (Field field : fields) {
                Class classType = field.getType();
                if (View.class.isAssignableFrom(classType)) {
                    field.setAccessible(true);
                    field.set(fragment, view.findViewById(getId(field.getName(), context)));
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    /**
     * find all fields in an activity with field name
     *
     * @param activity Activity
     */
    public static void findAll(Activity activity) {
        findAll(activity, 1);
    }

    /**
     * find all fields in an activity with field name. This search can find the fields in the superclasses as well.
     *
     * @param activity Activity
     * @param deepness if search is needed in the superclasses as well
     */
    public static void findAll(Activity activity, int deepness) {
        if (activity == null) {
            return;
        }
        try {
            Field[] fields;
            if (deepness != 1) {
                fields = getSuperClassFields(activity, deepness);
            } else {
                fields = activity.getClass().getDeclaredFields();
            }
            for (Field field : fields) {
                Class classType = field.getType();
                if (View.class.isAssignableFrom(classType)) {
                    field.setAccessible(true);
                    field.set(activity, activity.findViewById(getId(field.getName(), activity)));
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    /**
     * This helper method will get all the fields from a class and its superclasses.
     *
     * @param object The object's class will be used to get the fields.
     * @param deepness How deep we need to get the fields.
     */
    private static Field[] getSuperClassFields(Object object, int deepness) {
        List<Field> fieldsList = new ArrayList<>();
        Class clazz = object.getClass();
        int currentDeepness = 0;
        while (clazz != null && (deepness > 0 && currentDeepness < deepness)) {
            Field[] fieldsArray = clazz.getDeclaredFields();
            Collections.addAll(fieldsList, fieldsArray);
            clazz = clazz.getSuperclass();
            currentDeepness++;
        }
        Field[] fields = new Field[fieldsList.size()];
        fieldsList.toArray(fields);
        return fields;
    }

    /**
     * returns id from string
     *
     * @param id id
     * @param context Context
     */
    private static int getId(String id, Context context) {
        if (id == null || id.length() == 0 || context == null) {
            return -1;
        }
        return context.getResources().getIdentifier(id, "id", context.getPackageName());
    }

}