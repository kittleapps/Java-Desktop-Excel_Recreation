package com.kittleapps.ExcellRecreation;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Mechanics {
	public static void CalculateTotal(){

	}
	public static void CalculateAmount(int row, double value){
		DecimalFormat moneyFormat = new DecimalFormat("$ #0.00");
		moneyFormat.setRoundingMode(RoundingMode.UNNECESSARY);
		MainGUI.table.setValueAt(moneyFormat.format(value*Storage.PayPerMile), row, 4);
	}
	public static void FinalizeTotal(){

	}
	public static void FinalizeAmount(){

	}
	public static String MoneyFormat(double input){
		String Result = ""+input;
		if (Result.matches("[0123456789.,]+")) {
			NumberFormat nf = new DecimalFormat("##.00");
			Result = "$"+nf.format(input);
		}
		return Result;
	}
	public static void CopyReason(int RowToCopy){
		if (MainGUI.table.isEditing()){
			MainGUI.table.getCellEditor(MainGUI.table.getSelectedRow(), MainGUI.table.getSelectedColumn()).cancelCellEditing();
		}
		String ValueToCopy = MainGUI.table.getValueAt(RowToCopy, 5).toString();
		for (int row = 0; row < MainGUI.table.getRowCount(); row++){
			MainGUI.table.setValueAt(ValueToCopy, row, 5);
		}
		MainGUI.table.clearSelection();
	}
}
