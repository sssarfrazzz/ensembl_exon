insert into transcript(transcript_id, gene_id, analysis_id, seq_region_id, seq_region_start, seq_region_end, seq_region_strand, display_xref_id, source, biotype, description, is_current, canonical_translation_id, stable_id, version, created_date, modified_date)
values('1587', '554', '1', '132907', '577', '647', '1', '3159297', 'insdc', 'Mt_tRNA', NULL, '1', NULL, 'ENST00000387314', '1', '2006-05-12 00:00:00', '2006-05-12 00:00:00');


insert into exon(exon_id, seq_region_id, seq_region_start, seq_region_end, seq_region_strand, phase, end_phase, is_current, is_constitutive, stable_id, version, created_date, modified_date)
values ('5793', '132907', '577', '647', '1', '-1', '-1',' 1', '1', 'ENSE00001544501', '1', '2007-09-07 00:01:32', '2007-09-07 00:01:32');

insert into exon_transcript(exon_id, transcript_id, rank)
values ('5793', '1587', '1');

