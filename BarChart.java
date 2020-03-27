package 疫情;

import java.awt.Font;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import java.awt.GridLayout;
import javax.swing.JFrame;
public class BarChart {
	ChartPanel frame1;
	public  BarChart(){
		CategoryDataset dataset = getDataSet();//将获得的数据传递给CategoryDataset类的对象
       JFreeChart chart = ChartFactory.createBarChart3D(
      		                 "疫情统计", // 图表标题
                           "是否确诊", // 目录轴的显示标签
                           "人数", // 数值轴的显示标签
                           dataset, // 数据集
                           PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                           true, // 是否显示图例(对于简单的柱状图必须是false)
                           false,  // 是否生成工具
                           false  // 是否生成URL链接
                           );
      
       CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象
       CategoryAxis domainAxis=plot.getDomainAxis();         //水平底部列表
        domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题
        domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题
        ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状
        rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
         chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
         chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体

        frame1=new ChartPanel(chart,true);  //这里也可以用chartFrame,可以直接生成一个独立的Frame
        
	}
	   private static CategoryDataset getDataSet() {
          DefaultCategoryDataset dataset = new DefaultCategoryDataset();
          dataset.addValue(100, "是", "是");
          dataset.addValue(40, "否", "否");
          return dataset;
	   }
	   public ChartPanel getChartPanel(){
		   return frame1;
	
	   	}
	   public static void main(String args[]){
		   JFrame frame=new JFrame("疫情统计");
		   frame.setLayout(new GridLayout(2,2,10,10));
		   frame.add(new BarChart().getChartPanel());   //添加柱形图
		   frame.setBounds(0, 0, 900, 800);
		   frame.setVisible(true);
	   }
}
