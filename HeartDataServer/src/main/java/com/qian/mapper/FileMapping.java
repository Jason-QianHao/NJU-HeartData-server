package com.qian.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.qian.Entity.FileEntity;
import com.qian.algorithm.Report;

public interface FileMapping {

	/*
	 * 插入一个文件
	 */
	@Insert("insert into `file_info` (`file_name`, `file_url`, `year`, `month`, `day`,"
			+ " `pepole_id`, `client_created`) "
			+ "values(#{fileName}, #{fileUrl}, #{year}, #{month}, #{day}"
			+ ", #{pepoleId}, #{clientCreated});")
	public void addFile(FileEntity fileEntity);
	
	/*
	 * 根据时间ymd查找所有新增的记录
	 */
	@Select("select * from `file_info` where year=#{year} and month=#{month} and day=#{day}")
	public List<FileEntity> getFilesListByYMD(@Param("year")String year, @Param("month")String month, 
			@Param("day")String day);
	
	
	/*
	 * 查询一个人的所有文件
	 */
	@Select("select * from `file_info` where `pepole_id`=#{pepoleId};")
	public List<FileEntity> getAllFilesByPepoleId(@Param("pepoleId") int pepoleId);
	
	/*
	 * 查询一个人某一天的所有文件
	 */
	@Select("select * from `file_info` where `pepole_id`=#{pepoleId} and `client_created` like '#{day}%;")
	public List<FileEntity> getFilesByPepoleIdAndTime(@Param("pepoleId") int pepoleId, @Param("day") String day);
}
