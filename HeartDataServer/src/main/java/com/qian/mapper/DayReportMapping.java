package com.qian.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.qian.Entity.algorithm.DayReport;

public interface DayReportMapping {

	/*
	 * 插入一个记录
	 */
	@Insert("insert into `day_report` values(null, #{y}, #{m}, #{d}, #{imgurl}, #{isUsed}, #{healthIndex},"
			+ "#{pepoleId})")
	public void insertDayReport(DayReport dayReport);
	
	/*
	 * 根据openid、year、month查询所有缩略日报告
	 */
	@Select("select * from `day_report` where `y`=#{y} and `m`=#{m} and `pepole_id`=#{pepoleId} ORDER BY d;")
	public List<DayReport> getAllDayReportByYearAndMonth(@Param("y") int year, @Param("m") int month, 
			@Param("pepoleId") int pepoleId);
	
	/*
	 * 根据openid、year、month、day查询当日报告
	 */
	@Select("select * from `day_report` where `y`=#{y} and `m`=#{m} and `d`=#{d} and `pepole_id`=#{pepoleId};")
	public DayReport getDayReportByYearAndMonthAndDay(@Param("y") int year, @Param("m") int month, @Param("d") int day,
			@Param("pepoleId") int pepoleId);
}
