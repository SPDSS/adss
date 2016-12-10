/*******************************************************************************
 * Copyright (c) 2016 Politecnico di Torino.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Politecnico di Torino - initial API and implementation
 *******************************************************************************/
package eu.aspire_fp7.adss.akb.ui.providers;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.TreeItem;

import eu.aspire_fp7.adss.akb.ApplicationPart;
import eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation;
import eu.aspire_fp7.adss.akb.AttackMitigation;
import eu.aspire_fp7.adss.akb.AttackPath;
import eu.aspire_fp7.adss.akb.AttackStep;
import eu.aspire_fp7.adss.akb.AttackerTool;
import eu.aspire_fp7.adss.akb.Level;
import eu.aspire_fp7.adss.akb.Protection;
import eu.aspire_fp7.adss.akb.ProtectionObjective;
import eu.aspire_fp7.adss.akb.Solution;
import eu.aspire_fp7.adss.akb.SolutionSequence;
import eu.aspire_fp7.adss.akb.ui.Activator;
import eu.aspire_fp7.adss.util.Eclipse;
import eu.aspire_fp7.adss.util.Strings;
import eu.aspire_fp7.adss.util.StyleType;
import eu.aspire_fp7.adss.util.StyledText;
import eu.aspire_fp7.adss.util.Styles;

/**
 * The name label provider.
 * @author Daniele Canavese
 **/
public class NameLabelProvider extends StyledCellLabelProvider implements ILabelProvider
{
	/** Indicates if emphasizing the name of the assets or not. **/
	private boolean emphasizeAssets;

	/**
	 * Creates the label provider.
	 * @param emphasizeAssets
	 *            Indicates if the name of the assets should be emphasized.
	 **/
	public NameLabelProvider(boolean emphasizeAssets)
	{
		this.emphasizeAssets = emphasizeAssets;
	}

	/**
	 * Updates a cell content.
	 * @param cell
	 *            The cell.
	 **/
	@Override
	public void update(ViewerCell cell)
	{
		Object element = cell.getElement();
		StyledText styledText = getStyledText(element);
		Image image = getImage(element);

		if (styledText != null)
		{
			cell.setText(styledText.getText());
			cell.setStyleRanges(styledText.getStyleRanges());
			cell.setImage(image);

			if (cell.getItem() instanceof TreeItem)
			{
				TreeItem item = (TreeItem) cell.getItem();
				if (cell.getElement() instanceof Protection)
				{
					Protection protection = (Protection) cell.getElement();
					item.setChecked(protection.isEnabled());
				}
				else
					item.setGrayed(true);
			}
		}
	}

	/**
	 * Retrieves the image of the cell.
	 * @param element
	 *            The element.
	 * @return The image of the cell.
	 **/
	@Override
	public Image getImage(Object element)
	{
		try
		{
			if (element instanceof ApplicationPart && ((ApplicationPart) element).isCode())
				return Eclipse.getImage(Activator.PLUGIN_ID, "icons/code.png");
			else if (element instanceof ApplicationPart && ((ApplicationPart) element).isDatum())
				return Eclipse.getImage(Activator.PLUGIN_ID, "icons/datum.png");
			else if (element instanceof AttackStep)
				return Eclipse.getImage(Activator.PLUGIN_ID, "icons/attackStep.png");
			else if (element instanceof Protection)
			{
				Protection protection = (Protection) element;
				if (protection.isEnabled())
					return Eclipse.getImage(Activator.PLUGIN_ID, "icons/protection.png");
				else
					return Eclipse.getImage(Activator.PLUGIN_ID, "icons/protection.png", "icons/clear.png", IDecoration.BOTTOM_LEFT);
			}
			else if (element instanceof AttackerTool)
			{
				AttackerTool attackerTool = (AttackerTool) element;
				if (attackerTool.isEnabled())
					return Eclipse.getImage(Activator.PLUGIN_ID, "icons/attackerTool.png");
				else
					return Eclipse.getImage(Activator.PLUGIN_ID, "icons/attackerTool.png", "icons/clear.png", IDecoration.BOTTOM_LEFT);
			}
			else if (element instanceof AttackMitigation)
			{
				AttackMitigation attackMitigation = (AttackMitigation) element;
				if (attackMitigation.getLevel() == Level.LOW)
					return Eclipse.getImage(Activator.PLUGIN_ID, "icons/low.png");
				else if (attackMitigation.getLevel() == Level.MEDIUM)
					return Eclipse.getImage(Activator.PLUGIN_ID, "icons/medium.png");
				else
					return Eclipse.getImage(Activator.PLUGIN_ID, "icons/high.png");
			}
			else if (element instanceof Solution)
				return Eclipse.getImage(Activator.PLUGIN_ID, "icons/solution.png");
			else if (element instanceof SolutionSequence)
				return Eclipse.getImage(Activator.PLUGIN_ID, "icons/solutionSequence.png");
			else if (element instanceof AppliedProtectionInstantiation)
				return Eclipse.getImage(Activator.PLUGIN_ID, "icons/appliedProfile.png");
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Retrieves the styled text of the cell.
	 * @param element
	 *            The element.
	 * @param cell
	 *            The cell.
	 * @return The styled text of the cell.
	 **/
	public StyledText getStyledText(Object element)
	{
		if (element instanceof ApplicationPart)
		{
			ApplicationPart applicationPart = (ApplicationPart) element;
			String type;
			if (applicationPart.isCode())
				type = "code";
			else
				type = "datum";
			StyleType style = applicationPart.isAsset() && emphasizeAssets == true ? StyleType.EMPHASIS : StyleType.NORMAL;
			return Styles.format(applicationPart.getName(), type, 0, style);
		}
		else if (element instanceof AttackPath)
		{
			AttackPath attackPath = (AttackPath) element;
			Collection<String> targets = new ArrayList<>();
			for (ProtectionObjective i : attackPath.getProtectionObjectives())
				targets.add(i.getProperty().getLiteral() + " of " + i.getApplicationPart().getName());
			return Styles.format("Attack path #" + attackPath.getId(), Strings.join(targets, ", "), attackPath.getAttackSteps().size(),
					StyleType.NORMAL);
		}
		else if (element instanceof AttackStep)
			return new StyledText(element.toString());
		else if (element instanceof Protection)
		{
			Protection protection = (Protection) element;

			StyleType style = protection.isEnabled() ? StyleType.NORMAL : StyleType.CANCEL;
			boolean used = false;

			for (AttackMitigation i : protection.getMitigations())
				if (!i.getAttackPaths().isEmpty())
				{
					used = true;
					break;
				}

			if (used)
				style = StyleType.EMPHASIS;

			String instantiationsText = "";
			if (protection.getInstantiations().size() == 0)
				instantiationsText = "no protection instantiations";
			else if (protection.getInstantiations().size() == 1)
				instantiationsText = "1 protection instantiation";
			else
				instantiationsText = protection.getInstantiations().size() + " protection instantiations";
			return Styles.format(Strings.capitalize(protection.getName()), instantiationsText, null, style);
		}
		else if (element instanceof AttackerTool)
		{
			AttackerTool attackerTool = (AttackerTool) element;

			StyleType style = attackerTool.isEnabled() ? StyleType.NORMAL : StyleType.CANCEL;
			return Styles.format(attackerTool.getName(), null, 0, style);
		}
		else if (element instanceof AttackMitigation)
		{
			AttackMitigation attackMitigation = (AttackMitigation) element;
			return Styles.format(Strings.capitalize(attackMitigation.getType() + ": " + attackMitigation.getLevel() + " effectiveness"),
					null, attackMitigation.getAttackPaths().size(), StyleType.NORMAL);
		}
		else if (element instanceof Solution)
		{
			Solution solution = (Solution) element;
			if(solution.getFirstLevelSolution()==null)
				return Styles.format("Solution " + solution.getId() + " [score = " + solution.getScore() + "]", null, 0, StyleType.NORMAL);
			else
				return Styles.format("Solution " + solution.getId() + " (" + solution.getFirstLevelSolution().getId() + ") " +
						"[score = " + solution.getScore() + "]", null, 0, StyleType.NORMAL);
		}
		else if (element instanceof SolutionSequence)
			return Styles.format("Sequence", null, 0, StyleType.NORMAL);
		else if (element instanceof AppliedProtectionInstantiation)
		{
			AppliedProtectionInstantiation appliedInstantiation = (AppliedProtectionInstantiation) element;
			return Styles.format(appliedInstantiation.getProtectionInstantiation() + " @ " + appliedInstantiation.getApplicationPart(),
					null, 0, StyleType.NORMAL);
		}
		else
			return null;
	}

	/**
	 * Retrieves the text of the cell.
	 * @param element
	 *            The element.
	 * @return The text of the cell.
	 **/
	@Override
	public String getText(Object element)
	{
		return getStyledText(element).getText();
	}
}
