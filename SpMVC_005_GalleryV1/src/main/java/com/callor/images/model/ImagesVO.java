package com.callor.images.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImagesVO {
	
	private long i_seq;
	private long i_bseq;
	private String i_originalName;
	private String i_imageName;

}
