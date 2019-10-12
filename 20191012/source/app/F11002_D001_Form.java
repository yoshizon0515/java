package com.example.sample;

import java.util.LinkedHashMap;

public class F11002_D001_Form
{

	public F11002_D001_Form()
	{
		this.lvlTransMap = new LinkedHashMap<>();
		this.lvlTransMap.put(0, null);
	}

	//key:レベル移動番号 
	//value: LvlTransInfo 一覧、親の一覧の検索条件と[配下一覧]
	//が選択されたデータがが格納されたentity
	private LinkedHashMap<Integer, LvlTransInfo> lvlTransMap;

	public LinkedHashMap<Integer, LvlTransInfo> getLvlTransMap()
	{
		return lvlTransMap;
	}

	public void setLvlTransMap(LinkedHashMap<Integer, LvlTransInfo> lvlTransMap)
	{
		this.lvlTransMap = lvlTransMap;
	}



}
