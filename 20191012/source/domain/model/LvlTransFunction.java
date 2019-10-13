package com.example.sample;

/**
 * レベル遷移処理・および一覧検索条件・親の一覧検索条件・一覧から選択され[配下一覧]
 * ボタンを押下する際に選択されたデータの保持を行う関数インターフェース。
 * このインターフェース外で上記の処理は一切行わない。
 *
 *
 * @author ryota
 *
 * @param <F> Formクラス
 * @param <E> 一覧から選択されたFindListエンティティ
 */
@FunctionalInterface
public interface LvlTransFunction<F , E>
{
	public Integer apply(F f, E e);

}
