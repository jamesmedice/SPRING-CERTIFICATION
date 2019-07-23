package com.medici.app.spring.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.medici.app.spring.service.MusicService;

@Service
@CacheConfig(cacheNames = { "directory", "instruments" })
public class MusicServiceIml implements MusicService {

	private static List<String> instruments = new ArrayList<String>(Arrays.asList("Guitar", "Bass", "Bassoon", "Cello", "Cymbal", "Drum kit", "Euphonium", "Flute", "French horn", "Glockenspiel", "Harpsichord",
			"Mandolin", "Oboe", "Ocarina", "Octobass", "Organ" , "Pan Pipes", "Pennywhistle", "Saxophone", "Sitar", "Synthesizer", "Tambourine"));

	@Cacheable(unless = "#result.size() > 25")
	@Override
	public List<String> findAll() {
		System.out.println("Executing: " + this.getClass().getSimpleName() + ".findAll(); total: " + instruments.size());
		return instruments;
	}

	@Cacheable
	@Override
	public String findByIndex(int index) {
		System.out.println("Executing: " + this.getClass().getSimpleName() + ".findByIndex(\"" + index + "\");");
		return instruments.get(index);
	}

	@CachePut
	@Override
	public void save(String instrument) {
		System.out.println("Executing: " + this.getClass().getSimpleName() + ".save(\"" + instrument + "\");");
		instruments.add(instrument);
	}

	@CacheEvict
	@Override
	public void delete(String instrument) {
		System.out.println("Executing: " + this.getClass().getSimpleName() + ".delete(\"" + instrument + "\");");
		instruments.remove(instrument);
	}

	@CacheEvict(allEntries = true)
	@Override
	public void deleteAll() {
		System.out.println("Executing: " + this.getClass().getSimpleName() + ".deleteAll();");
		instruments.removeAll(instruments);
	}

	@Cacheable(condition = "#instrument.equals('trombone')")
	public String play(String instrument) {
		System.out.println("Executing: " + this.getClass().getSimpleName() + ".play(\"" + instrument + "\");");
		return "paying " + instrument + "!";
	}
}