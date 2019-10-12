package com.example.sample;

import com.example.sample.domain.S001.F11002_D001_LstCond;
import com.example.sample.domain.S001.F11002_PrntLstCond;

public class LvlTransInfo
{


	private LvlTransInfo() {};


	public LvlTransInfo(F11002_D001_FindList select ,F11002_D001_LstCond istCond, F11002_PrntLstCond prntLstCond)
	{
		this.select = select;
		this.istCond = istCond;
		this.prntLstCond = prntLstCond;
	}

	//[配下一覧]を押下した一覧のレコード
	private F11002_D001_FindList select;
	//一覧の検索条件
	private F11002_D001_LstCond istCond;
	//親の一覧の検索条件
	private F11002_PrntLstCond prntLstCond;

	public F11002_D001_LstCond getIstCond()
	{
		return istCond;
	}

	public void setIstCond(F11002_D001_LstCond istCond)
	{
		this.istCond = istCond;
	}

	public F11002_PrntLstCond getPrntLstCond()
	{
		return prntLstCond;
	}

	public void setPrntLstCond(F11002_PrntLstCond prntLstCond)
	{
		this.prntLstCond = prntLstCond;
	}

	public F11002_D001_FindList getSelect()
	{
		return select;
	}

	public void setSelect(F11002_D001_FindList select)
	{
		this.select = select;
	}


}
