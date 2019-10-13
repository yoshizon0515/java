package com.example.sample;

import java.util.HashMap;
import java.util.Map;

public class F11002_D001_Form
{

	public F11002_D001_Form()
	{
		this.lvlTransMap = new HashMap<>();
		this.lvlTransMap.put(0, null);
	}

	//key:レベル移動番号 value:検索条件が格納されたentity
	private Map<Integer, LvlTransInfo> lvlTransMap;

	public Map<Integer, LvlTransInfo> getLvlTransMap()
	{
		return lvlTransMap;
	}

	public void setLvlTransMap(Map<Integer, LvlTransInfo> lvlTransMap)
	{
		this.lvlTransMap = lvlTransMap;
	}





}
