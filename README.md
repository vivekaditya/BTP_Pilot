BTP_Pilot
=========

			BTP POC
	TAC 2014 Biomedical Summarization Track
http://www.nist.gov/tac/2014/BiomedSumm/index.html#schedule


TAC 2014 Biomedical Summarization Track
Overview

Since 2001, the US National Institute of Standards and Technology (NIST) has organized large-scale shared tasks for automatic text summarization within the Document Understanding Conference (DUC) and the Summarization track at the Text Analysis Conference (TAC). However, while DUC and TAC generated a wealth of evaluation resources for news summarization, far less material is available to support development of methods of automatic summarization in other domains where there is also a pressing need for distillation and management of complex information presented in vast amounts of text.

Today, finding an overview of specific developments in biomedicine requires painstaking work. The existence of surveys tells us that such information is desirable, but such surveys require considerable time and human effort, and cannot keep up with the rate of scientific publication. For example, papers are added to PubMed alone at the rate of about 1.5 article per minute, precluding the possibility of manual summarization of the scientific literature.

There are currently two ways in which scientific papers are usually summarized: first, by the abstract that the author provides, and second, when a paper is being cited, a brief summary of pertinent points in the cited paper is often given. However, both of these methods fall short of addressing the reader's needs, which are: for the abstract, to know what the lasting influence of a paper is; for references, to know how the author originally expressed the claim.

The set of citation sentences (i.e., "citances") that reference a specific paper can be seen as a (community created) summary of that paper (see e.g. [1,2]). The set of citances is taken to summarize the key points of the referenced paper, and so reflects the importance of the paper within an academic community. Among the benefits of this form of summarization is that the citance offers a new type of context that was not available at the time of authoring of the citation: often, in citation, papers are combined, compared or commented on - therefore, the collection of citations to a reference paper adds an interpretative layer to the cited text.

The drawback, however, is that though a collection of citances offers a view of the cited paper, it does not provide a context, in terms of data or methods, of the cited finding; if the citation is of a method, the data and results may not be cited. More seriously, a citing author can attribute findings or conclusions to the cited paper that are not present, or not intended in that form (e.g., the finding is subject to specific experimental conditions which are not cited). To provide more context, and to establish trust in the citance, the reader would need to see, next to the citance, the exact span(s) of text (or tables or figures) that are being cited, and be able to link in to the cited text at this exact point.

To give the abstract-as-summary the benefit of community insight, and to give the citances-as-summary the benefit of context, we explore a new form of structured summary: a faceted summary of the traditional self-summary (the abstract) and the community summary (the collection of citances). As a third component, we propose to group the citances by the facets of the text that they refer to.

A pilot study indicated that most citations clearly refer to one or more specific aspects of the cited paper. For biology, this is usually either the goal of the paper, the method, the results or data obtained, or the conclusions of the work. This insight can help create more coherent citation-based summaries: by identifying first, the cited text span, and second, the facet of the paper (Goal, Method, Result/Data or Conclusion), we can create a faceted summary of the paper by clustering all cited/citing sentences together by facet.

Use Case: This form of scientific summarization could be a component of a User Interface in which a user is able to hover over or click on a citation, which then causes a citance-focused faceted summary of the referenced paper to be displayed, or a full summary of the referenced paper taking into account the citances in all citing papers for that reference paper. Finally, this form of scientific summarization would allow a user to read the original reference paper, but with links to the subsequent literature that cites specific ideas of the reference paper.
Task Description

The automatic biomedical summarization task is defined as follows:

Given: A set of Citing Papers (CPs) that all contain citations to a Reference Paper (RP). In each CP, the text spans (i.e., citances) have been identified that pertain to a particular citation to the RP.

Task 1a: For each citance, identify the spans of text (cited text spans) in the RP that most accurately reflect the citance. These are of the granularity of a sentence fragment, a full sentence, or several consecutive sentences (no more than 5).

Task 1b: For each cited text span, identify what facet of the paper it belongs to, from a predefined set of facets.

Task 2: Finally, generate a structured summary of the RP and all of the community discussion of the paper represented in the citances. The length of the summary should not exceed 250 words. Task 2 is tentative.

Evaluation: Task 1 will be scored by overlap of text spans in the system output vs gold standard. Task 2 will be scored using the ROUGE family of metrics [3]. Again, Task 2 is tentative.

This biomedical summarization task and dataset is expected to be of interest to a broad community including those working in biomedical NLP, text summarization, discourse structure in scholarly discourse, and paraphrase, textual entailment, and/or text simplification.
Preliminary Schedule

    TAC BiomedSumm 2014 Schedule
    Early May	Initial track guidelines posted
    end May	Distribution of first release of training data
    June 30	Deadline for registration for track participation
    July 31	Distribution of final release of training data
    August 11-22	BiomedSumm evaluation window
    mid September	Release of individual evaluated results to participants
    October 7	Deadline for short system descriptions (required)
    October 7	Deadline for workshop presentation proposals
    mid October	Notification of acceptance of presentation proposals
    November 1	Deadline for system reports (workshop notebook version, required)
    November 17-18	TAC 2014 workshop in Gaithersburg, Maryland, USA
    February 15, 2015	Deadline for system reports (final proceedings version, required)

References

[1] Preslav I. Nakov, Ariel S. Schwartz, and Marti A. Hearst (2004) Citances: Citation sentences for semantic analysis of bioscience text. SIGIR 2004.

[2] Vahed Qazvinian, Dragomir R. Radev. 2010. Identifying Non-explicit Citing Sentences for Citation-based Summarization. In Proceedings of Association for Computational Linguistics.

[3] Chin-Yew Lin (2004) ROUGE: A package for automatic evaluation of summaries. Proceedings of "Text Summarization Branches Out," pp. 74-81.
Organizing Committee
Kevin Bretonnel Cohen (University of Colorado School of Medicine, USA)
Hoa Trang Dang (National Institute of Standards and Techonology, USA)
Anita de Waard (Elsevier Labs, USA)
Prabha Yadav (University of Colorado School of Medicine, USA)
Lucy Vanderwende (Microsoft Research, USA)


