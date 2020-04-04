package web.flatremainder.config;


import java.util.List;

import web.flatremainder.common.model.MST_USER;
import web.flatremainder.common.model.SelectBox;

public interface CommonServics
{
	/**
	 * ユーザーテーブルからIDで検索し該当しているレコードを取得
	 * 
	 * @param id
	 * @return
	 */
	public MST_USER getUserEntityOne(String id);

	/**
	 * 最終ログイン日時更新
	 */
	public void updLastLogindate(String login_id);
	
	
	/**
	 * 各種種別セレクトボックス作成
	 */
	public List<SelectBox> createClsSelectbox(boolean blanks, String clsId);

	/**
	 * 期限切れフラグ更新（リスト表示時に毎回使用）
	 * リマインダー以外はなにもしない
	 */
	public void updExpiredFlg(String article_cls);
}