package com.example.sample;

import java.util.LinkedHashMap;
import java.util.function.Consumer;

import org.springframework.beans.BeanUtils;

import com.example.sample.domain.S001.F11002_D001_LstCond;
import com.example.sample.domain.S001.F11002_PrntLstCond;

/**
 * F11002_D001 検索・配下一覧・親のレベルに戻るボタン押下時の
 * レベル移動の管理。検索パラメータ、
 *
 * @author ryota
 *
 */
class LvlTransUtil
{
	/**
	 * 検索ボタン押下時のレベル移動処理
	 * 0以上のキーのデータをすべて削除する。その後一覧の検索条件をセットする
	 * @param form
	 * @return 値をセットした後の最大のキー(レベル移動番号)
	 */
	static LvlTransFunction<F11002_D001_Form,  F11002_D001_FindList> searchAction()
	{

	     LvlTransFunction<F11002_D001_Form,  F11002_D001_FindList> search = (f, e) ->
		{

			Integer level = 0;

			//0以上のキーを削除
			searchDelete().accept(f.getLvlTransMap());

			F11002_D001_LstCond lstCond = new F11002_D001_LstCond();

			//フォームの検索条件を一覧の検索条件にコピー
			BeanUtils.copyProperties(f, lstCond);

			//一覧の検索条件をセット
			//レベル0の場合、親の一覧の検索条件はセットしない
			f.getLvlTransMap().put(level, new LvlTransInfo(e, lstCond, null));

			return level;

		};

		return search;

	}


	static LvlTransFunction<F11002_D001_Form,  F11002_D001_FindList> underAction()
	{
		LvlTransFunction<F11002_D001_Form,  F11002_D001_FindList> under = (f, e) ->
		{

			//key:レベル移動番号の最大値 + 1 value:
			Integer newLevel = maxKeyValue(f) + 1;

			//条件をセット
			F11002_D001_LstCond lstCond = new F11002_D001_LstCond();
			//条件をセット
			F11002_PrntLstCond prntLstCond = new F11002_PrntLstCond();


			f.getLvlTransMap().put(newLevel, new LvlTransInfo(e, lstCond, prntLstCond));

			return newLevel;

		};

		return under;
	}

	static LvlTransFunction<F11002_D001_Form,  F11002_D001_FindList> backPrntLvl()
	{

		LvlTransFunction<F11002_D001_Form,  F11002_D001_FindList> backPrntLvl = (f, e) ->
		{

			//最大レベルを取得
			Integer maxLevel = maxKeyValue(f);
			//最大レベルを削除
			f.getLvlTransMap().remove(maxLevel);

			//最大レベルを削除したので最大レベルから1引いた数を返す
			return --maxLevel;

		};

		return backPrntLvl;
	}


	/**
	 * 最大のレベル移動番号のentityを取得
	 */
	static LvlTransInfo getMaxKeyEntity(F11002_D001_Form form)
	{
		return form.getLvlTransMap().get(maxKeyValue(form));
	}



	/**
	 * キーの最大値を取得
	 * @param form
	 * @return
	 */
	private static Integer maxKeyValue(F11002_D001_Form form)
	{
		return form.getLvlTransMap().keySet().stream()
				.mapToInt(s -> s.intValue()).max().getAsInt();
	}


	/**
	 * レベル移動番号が0以外のデータを削除
	 * @return
	 */
	private static Consumer<LinkedHashMap<Integer, LvlTransInfo>> searchDelete()
	{
		Consumer<LinkedHashMap<Integer, LvlTransInfo>> delete =
				lvlMap -> {lvlMap.keySet().forEach(key -> {if(key > 0) {lvlMap.remove(key); }});
		};

		return delete;

	}


}
