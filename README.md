# Xenium_IMC_OVA
This repository contains code for the spatial transcriptomic and proteomic analysis of the adult human ovary. This repository contains code for the spatial transcriptomic and proteomic analysis of the adult human ovary. Using Xenium and Imaging Mass Cytometry (IMC) data, we implemented quality control, normalization, dimensionality reduction, clustering, and differential expression analysis with Python (Scanpy, CellCharter, Squidpy) and R (cytomapper, ComplexHeatmap). The pipeline integrates spatial coordinates to visualize cellular distribution, identify immune subpopulations, and uncover cell–cell interactions involved in follicular remodeling.


🧬 Xenium In Situ Data Analysis

Xenium spatial transcriptomic data were analyzed using Python and the Scanpy framework. After constructing an AnnData object, quality control was applied to filter out low-quality cells and low-abundance genes. The data were normalized, log-transformed, and reduced using PCA and UMAP. Clustering was performed with the Leiden algorithm, and differentially expressed genes were identified via the Wilcoxon test. For immune-related analysis, we focused on PTPRC+ cells to identify subtypes and dynamics during follicular remodeling. Spatial annotations of follicle types were integrated from QuPath, and spatial visualization was performed using matplotlib (Python) and ggplot2 (R). Cell niche identification and neighborhood enrichment were carried out using CellCharter and Squidpy.


🧪 IMC Data Analysis

IMC data processing began by converting raw .mcd files to TIFF using steinbock. Cell segmentation was performed with the DeepCell module and refined with CellPose. Marker intensities were extracted and imported into R for downstream analysis using imcRtools, cytomapper, and SpatialExperiment. After arcsinh transformation, dimensionality reduction (tSNE) and clustering (Phenograph) were conducted. Clusters were annotated based on protein expression, and follicular regions were annotated in QuPath. Immune cell subsets were further analyzed, and spatial neighborhood relationships were assessed with Squidpy. Visualization of spatial data was performed using ComplexHeatmap and cytomapper.
