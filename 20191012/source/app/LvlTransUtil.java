package com.example.sample;

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
	 * マップの中身をすべて削除し、その後一覧の検索条件をセットする
	 * @return 値をセットした後の最大のキー(レベル移動番号)
	 */
	static LvlTransFunction<F11002_D001_Form,  F11002_D001_FindList> searchAction()
	{

	     LvlTransFunction<F11002_D001_Form,  F11002_D001_FindList> search = (f, e) ->
		{

			Integer lvlIdoBngo = 0;

			//マップの中身を全削除
			f.getLvlTransMap().clear();

			F11002_D001_LstCond lstCond = new F11002_D001_LstCond();

			//フォームの検索条件を一覧の検索条件にコピー
			BeanUtils.copyProperties(f, lstCond);

			//一覧の検索条件をセット
			//一覧選択entity・親の一覧の検索条件はセットしない
			f.getLvlTransMap().put(lvlIdoBngo, new LvlTransInfo(null, lstCond, null));

			return lvlIdoBngo;

		};

		return search;

	}


	/**
	 * [配下一覧]ボタン押下時の処理。
	 * 最大のレベル移動番号を発番し、一覧の検索条件・親の一覧の検索条件・選択されたentityを
	 * クラスに格納し保存する。
	 * @return 値をセットした後の最大のキー(レベル移動番号)
	 */
	static LvlTransFunction<F11002_D001_Form,  F11002_D001_FindList> underAction()
	{
		LvlTransFunction<F11002_D001_Form,  F11002_D001_FindList> under = (f, e) ->
		{

			//key:レベル移動番号の最大値 + 1 value:
			Integer lvlIdoBngo = maxKeyValue(f) + 1;

			//条件をセット
			F11002_D001_LstCond lstCond = new F11002_D001_LstCond();
			//条件をセット
			F11002_PrntLstCond prntLstCond = new F11002_PrntLstCond();


			f.getLvlTransMap().put(lvlIdoBngo, new LvlTransInfo(e, lstCond, prntLstCond));

			return lvlIdoBngo;

		};

		return under;
	}

	/**
	 * [親の一覧]に戻る ボタン押下時の処理。最大のレベル移動番号のデータをマップから削除
	 * @return 値をセットした後の最大のキー(レベル移動番号)
	 */
	static LvlTransFunction<F11002_D001_Form,  F11002_D001_FindList> backPrntLvl()
	{

		LvlTransFunction<F11002_D001_Form,  F11002_D001_FindList> backPrntLvl = (f, e) ->
		{

			//最大レベルを取得
			Integer maxLevel = maxKeyValue(f);
			//最大レベルを削除
			f.getLvlTransMap().remove(maxLevel);

			//最大レベルを削除後の最大レベルを返す。
			return maxKeyValue(f);

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



}
