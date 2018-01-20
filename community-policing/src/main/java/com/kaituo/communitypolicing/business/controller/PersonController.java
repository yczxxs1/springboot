package com.kaituo.communitypolicing.business.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaituo.communitypolicing.business.condition.Condition;
import com.kaituo.communitypolicing.business.domain.Person;
import com.kaituo.communitypolicing.business.domain.PersonType;
import com.kaituo.communitypolicing.business.form.PermanentPersonForm;
import com.kaituo.communitypolicing.business.service.PersonService;
import com.kaituo.communitypolicing.business.vo.PermanentPersonListVo;
import com.kaituo.communitypolicing.business.vo.PersonDetailVo;
import com.kaituo.communitypolicing.common.result.ResultUtil;
import com.kaituo.communitypolicing.common.result.ResultVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/person")
@Api(tags = "人员")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/{personId}")
	@ApiOperation(value="查看人员详情")
	public ResultVo<PersonDetailVo> getPerson(@PathVariable String personId){
		
		return ResultUtil.success(modelMapper.map(personService.getPerson(personId), PersonDetailVo.class));
		
	}
	
	@GetMapping("/permanentList")
	@ApiOperation(value="条件查询常住人口")
	public ResultVo<List<PermanentPersonListVo>> listPermanentPersons(PermanentPersonForm form){
		Condition condition=modelMapper.map(form, Condition.class);
		condition.setPersonType(PersonType.PERMANENT.getCode());
		List<Person> persons=personService.listByConditon(condition);
		return ResultUtil.success(modelMapper.map(persons,new TypeToken<List<PermanentPersonListVo>>() {}.getType()));
		
	}
}
