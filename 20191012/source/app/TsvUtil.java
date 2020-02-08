package com.example.demo;

import com.example.demo.sample1.model.MultiRowHeader;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.IntStream;

public class TsvUtil
{
    /**
     * 結果のリストにヘッダ行を差し込む。
     *
     * ・注意
     * リストのジェネリックスに設定されたモデルクラスにデフォルトコンストラクタを設定すること。
     * モデルに@MultiRowHeaderアノテーションを設定する。引数の配列には出力するヘッダの値を順番に書くこと。
     * 値の出力がない箇所にはから文字列""を設定する。@MultiRowHeaderアノテーションには全てのフィールドに
     * 同じ数の要素を与えること
     * 出力対象とならないフィールドには@JsonIgnoreを付与
     *
     * @param resultList ヘッダ行を差し込むリスト。リスト部分の取得前後は問わない
     * @param clazz モデルクラスのクラス
     * @param headerRow 差し込むヘッダの行数
     * @param includeSuper 継承しているスーパークラスのフィールドもヘッダとして出力するか
     * @param <T> モデルクラスの型
     */
    public static <T> void setMultiRowHeader(List<T> resultList, Class<T> clazz, int headerRow, boolean includeSuper)
    {

        //スーパークラスのフィールドも取得するかどうか
        Field[] fields = includeSuper
                ? ArrayUtils.addAll(clazz.getDeclaredFields(), clazz.getSuperclass().getDeclaredFields())
                : clazz.getDeclaredFields();

        IntStream.range(0, headerRow).forEach(count -> {

            try
            {

                T row = clazz.newInstance();

                for(Field field : fields)
                {
                    if(field.isAnnotationPresent(JsonIgnore.class) || !field.isAnnotationPresent(MultiRowHeader.class))
                    {
                        continue;
                    }

                    String title = field.getAnnotation(MultiRowHeader.class).value()[count];

                    if(StringUtils.isNotEmpty(title))
                    {
                        field.setAccessible(true);
                        field.set(row, title);
                    }
                }

                resultList.add(count, row);
            }
            catch (Exception e)
            {
                throw new RuntimeException(e);
            }

        });
    }

}
