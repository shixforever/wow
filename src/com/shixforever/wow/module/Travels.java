package com.shixforever.wow.module;

import java.util.ArrayList;
import java.util.List;

/*
 Copyright 2012 Aphid Mobile
	for wow data

 */
public class Travels {

	public static final List<Data> IMG_DESCRIPTIONS = new ArrayList<Data>();

	static {
		Travels.IMG_DESCRIPTIONS
				.add(new Travels.Data(
						"5.2前瞻",
						"leisheng.jpg",
						"5.2LM 新日常",
						"China", "Lhasa",
						"http://en.wikipedia.org/wiki/Potala_Palace"));
		Travels.IMG_DESCRIPTIONS
				.add(new Travels.Data(
						"防骗指南",
						"pianzi.png",
						"<b>人在江湖飘 哪能不挨刀 </b> wow里面也有各种毛人毛事,小白们可要擦亮眼睛，珍爱生命,远离骗子",
						"China", "Lhasa",
						"http://en.wikipedia.org/wiki/Drepung"));
//		Travels.IMG_DESCRIPTIONS
//				.add(new Travels.Data(
//						"Sera Monastery",
//						"sera_monastery.jpg",
//						"<b>Sera Monastery</b> is one of the 'great three' Gelukpa university monasteries of Tibet, located 1.25 miles (2.01 km) north of Lhasa.",
//						"China", "Lhasa",
//						"http://en.wikipedia.org/wiki/Sera_Monastery"));
//		Travels.IMG_DESCRIPTIONS
//				.add(new Travels.Data(
//						"Samye Monastery",
//						"samye_monastery.jpg",
//						"<b>Samye Monastery</b> is the first Buddhist monastery built in Tibet, was most probably first constructed between 775 and 779 CE.",
//						"China", "Samye", "http://en.wikipedia.org/wiki/Samye"));
//		Travels.IMG_DESCRIPTIONS
//				.add(new Travels.Data(
//						"Tashilunpo Monastery",
//						"tashilunpo_monastery.jpg",
//						"<b>Tashilhunpo Monastery</b>, founded in 1447 by Gendun Drup, the First Dalai Lama, is a historic and culturally important monastery next to Shigatse, the second-largest city in Tibet.",
//						"China", "Shigatse",
//						"http://en.wikipedia.org/wiki/Tashilhunpo_Monastery"));
//		Travels.IMG_DESCRIPTIONS
//				.add(new Travels.Data(
//						"Zhangmu Port",
//						"zhangmu_port.jpg",
//						"<b>Zhangmu/Dram</b> is a customs town and port of entry located in Nyalam County on the Nepal-China border, just uphill and across the Bhote Koshi River from the Nepalese town of Kodari.",
//						"China", "Zhangmu",
//						"http://en.wikipedia.org/wiki/Zhangmu"));
//		Travels.IMG_DESCRIPTIONS
//				.add(new Travels.Data(
//						"Kathmandu",
//						"kathmandu.jpg",
//						"<b>Kathmandu</b> is the capital and, with more than one million inhabitants, the largest metropolitan city of Nepal.",
//						"Nepal", "Kathmandu",
//						"http://en.wikipedia.org/wiki/Kathmandu"));
//		Travels.IMG_DESCRIPTIONS
//				.add(new Travels.Data(
//						"Pokhara",
//						"pokhara.jpg",
//						"<b>Pokhara Sub-Metropolitan City</b> is the second largest city of Nepal with approximately 250,000 inhabitants and is situated about 200 km west of the capital Kathmandu.",
//						"Nepal", "Pokhara",
//						"http://en.wikipedia.org/wiki/Pokhara"));
//		Travels.IMG_DESCRIPTIONS
//				.add(new Travels.Data(
//						"Patan",
//						"patan.jpg",
//						"<b>Patan</b>, officially Lalitpur Sub-Metropolitan City, is one of the major cities of Nepal located in the south-central part of Kathmandu Valley.",
//						"Nepal", "Patan",
//						"http://en.wikipedia.org/wiki/Patan,_Nepal"));
	}

	public static final class Data {
		public final String title;
		public final String imageFilename;
		public final String description;
		public final String country;
		public final String city;
		public final String link;

		private Data(String title, String imageFilename, String description,
				String country, String city, String link) {
			this.title = title;
			this.imageFilename = imageFilename;
			this.description = description;
			this.country = country;
			this.city = city;
			this.link = link;
		}
	}
}
