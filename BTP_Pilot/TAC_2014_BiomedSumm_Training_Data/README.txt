           TAC 2014 Biomedical Summarization Training Topics
                 
                          June 19, 2014


1. Overview

Text Analysis Conference (TAC) is a series of workshops organized by
the National Institute of Standards and Technology (NIST). TAC was
developed to encourage research in natural language processing (NLP)
and related applications by providing a large test collection, common
evaluation procedures, and a forum for researchers to share their
results. 

The Biomedical Summarization track of TAC encourages the development
of systems that can summarize biomedical research papers.  The
automatic biomedical summarization task is defined as follows:

Given: A topic consisting of a Reference Paper (RP) and 10 Citing
Papers (CPs) that all contain citations to the RP. In each CP, the
text spans (i.e., citances) have been identified that pertain to a
particular citation to the RP.

Task 1a: For each citance, identify the spans of text (cited text
spans) in the RP that most accurately reflect the citance. These are
of the granularity of a sentence fragment, a full sentence, or several
consecutive sentences (no more than 5).

Task 1b: For each cited text span, identify what facet of the paper it
belongs to, from a predefined set of facets.

Task 2: Finally, generate a structured summary of the RP and all of
the community discussion of the RP represented in the citances. The
length of the summary should not exceed 250 words.

For more information, please refer to the Biomedical Summarization
section of NIST's TAC website at
http://www.nist.gov/tac/2014/BiomedSumm/index.html

This package contains an initial (partial) release of training topics
to aid in the development of biomedical summarization systems.



2. Contents


./README.txt
 
  This file


./data/D14??_TRAIN
  
  Directories containing the Documents, Summaries, and Annotations for
  each topic, one directory per Topic ID.


./data/D14??_TRAIN/Documents_PDF/
  
  This directory contains the 11 source documents for the topic (1 RP
  and 10 CPs), one file per paper, in the original pdf format.


./data/14??_TRAIN/Documents_Text/

  This directory contains the 11 source documents for the topic in
  UTF-8 text format, where each txt file corresponds to the similarly
  named pdf file above.  All annotations and offsets for the topic are
  with respect to the text files in this directory.  Most text files
  were obtained directly from the sources listed in
  ./docs/sources/*.csv below, but in a small number of cases the
  University of Colorado had to create the text file from the pdf file
  using Adobe Acrobat.


./data/D14??_TRAIN/Annotation/

  This directory contains the annotation files for the topic, from 4
  different annotators.  The annotation files are named with the
  following convention: <TopicID>.<AnnotatorID>.ann.txt

  Each annotation file consists of the following pipe "|" separated
  fields:

   1: Topic ID: An ID for the topic, e.g., "D1401_TRAIN"

   2: Citance Number: A numeric ID for the citance for this topic,
   keyed by a unique combination of Reference Article, Citing Article,
   and Citation Marker Offset.

   3: Reference Article: Name of the reference paper in Documents_Text

   4: Citing Article: Name of the citing paper in Documents_Text

   5: Citation Marker Offset: pair of start and end offsets defining
   the text in the Citing Article for the Citation Marker of the
   citance.

   6: Citation Marker: Span of text defined by the Citation Marker
   Offset above.

   7: Citation Offset: Pair of start and end offsets defining the text
   in the Citing Article that contains the citation and conveys the
   authors' discussion of the citation.

   8: Citation Text: Span of text defined by the Citation Offset
   above.  Although the exact Citation Text span may vary between
   annotators, all Citation Text spans for the same Topic ID and
   Citance Number must have some overlap (minimally containing the
   same Citation Marker).

   9: Reference Offset: One to three pairs of offsets defining the
   portions of the Reference Article that the authors of the Citing
   Article are discussing in the citation.

  10: Reference Text: Span of text defined by the Reference Offset
  above. Discontiguous spans defined by multiple pairs of offsets are
  separated by ellipses "..."

  11: Discourse Facet: one of {Hypothesis_Citation, Method_Citation,
  Results_Citation, Implication_Citation, Discussion_Citation, and
  Dataset_Citation}

  12:  Annotator:  An alphabetic ID for the annotator 

  All offsets are UTF-8 character offsets into the source document,
  where the first character in the document has offset 0. An offset
  pair "start-end" provides the offset of the first character of the
  string and the offset of the character immediately after the last
  character of the string, respectively; thus, the length of the
  string is end - start.


./data/D14??_TRAIN/Summary/

  This directory contains the summary of the reference paper as a
  UTF-8 text file, taking into consideration not only the abstract for
  the reference paper itself, but also those parts of the reference
  paper that were mentioned by the citing papers and how the citing
  papers discussed the reference paper.  There is one summary (file)
  for each of the 4 annotators. The summary files are named with the
  following convention: <TopicID>.<AnnotatorID>.summary.txt


./docs/SciSumm-annotation-guidelines-V1.0.pdf
  
  Annotation guidelines for selecting the Citing Span and Reference
  Span for each Citance.


./docs/sources/*.csv

  References for each of the papers for each of the topics, one file
  per topic.



3. Annotation

Given a reference paper and 10 citing papers, annotators from the
University of Colorado School of Medicine were instructed to find
citations to the RP in the 10 CPs.  Annotators followed instructions
in SciSumm-annotation-guidelines-V1.0.pdf to mark the Citation Text,
Citation Marker, Reference Text, and Discourse Facet for each citation
of the RP found in the CP.  Finally, the annotator wrote a summary of
the RP that highlighted the merits of the reference paper and subsequent
discussions of the paper.


4. Contact Information

For further information about this data release, contact the following
members of the BiomedSumm Organizing Committee:

  Kevin B. Cohen (U. of Colorado School of Medicine)	<kevin.cohen@gmail.com>
  Hoa Trang Dang (NIST)		 	   		<hoa.dang@nist.gov>
  Anita de Waard (Elsevier Labs)			<A.dewaard@elsevier.com>
  Prabha Yadav (U. of Colorado School of Medicine)	<prabha.yadav@ucdenver.edu>
  Lucy Vanderwende (Microsoft Research)  		<Lucy.Vanderwende@microsoft.com>
  
--------------------------------------------------------------------------
README created by Hoa Dang on June 19, 2014

