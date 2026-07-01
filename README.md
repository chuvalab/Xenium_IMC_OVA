# Xenium_IMC_OVA

This repository contains code for the spatial transcriptomic and proteomic analysis of adult human ovarian follicular remodeling. Using Xenium in Situ and Imaging Mass Cytometry (IMC) data, we implemented quality control, normalization, dimensionality reduction, clustering, differential expression analysis, spatial niche analysis and neighborhood analysis. The pipeline integrates single-cell measurements with spatial coordinates to visualize cellular distribution, identify immune subpopulations and investigate their potential roles in follicular remodeling.

## Data availability

The Xenium in Situ and Imaging Mass Cytometry datasets generated in this study have been deposited in figshare under the title:

**Xenium In Situ and imaging mass cytometry dataset of adult human ovarian follicular remodeling**

DOI: https://doi.org/10.6084/m9.figshare.32506200

The dataset is currently private during peer review and will become publicly available upon publication. 

The deposited files include the Xenium cell-feature matrix, cell metadata, transcript coordinates, cell-boundary files and the IMC raw MCD file.


## System requirements

The analysis was performed using Python and R with open-source packages and standalone software tools. The main tested versions are listed below.

### Python environment and packages

- Python v3.10
- AnnData v0.10.9
- Scanpy v1.11
- CellCharter v0.3.0
- Squidpy v1.6.2
- Matplotlib v3.10.1
- steinbock v0.16.1
- DeepCell v0.12.1
- CellPose v3

### R environment and packages

- R v4.3
- imcRtools v1.12.0
- cytomapper v1.8.0
- SpatialExperiment v1.16.0
- scater v1.34.1
- phenograph v1.5.2
- ComplexHeatmap v2.22.0
- ggplot2 v3.5.1

### Standalone software

- QuPath v0.5.0
  
The full software environment is provided in the environment file included in this repository.

No non-standard hardware is required to inspect or run individual scripts. Running the full Xenium and IMC workflows on the complete datasets requires sufficient memory and storage, and runtime will depend on the local computing environment.

## Installation

Clone the repository:

```bash
git clone https://github.com/chuvalab/Xenium_IMC_OVA.git
cd Xenium_IMC_OVA
```

Create the analysis environment using the provided environment file:

```bash
conda env create -f environment.yml
conda activate Xenium_IMC_OVA
```

R packages should be installed according to the package versions listed above and in the environment file.

Typical installation time depends on the local system and package manager, but is expected to be approximately 30-60 minutes on a standard desktop or workstation.

## Xenium in Situ data analysis

Xenium spatial transcriptomic data were analyzed using Python and the Scanpy framework. After constructing an AnnData object, quality control was applied to filter low-quality cells and low-abundance genes. The data were normalized, log-transformed and reduced using PCA and t-SNE. Clustering was performed with the Leiden algorithm, and differentially expressed genes were identified using the Wilcoxon rank-sum test.

For immune-related analysis, PTPRC-positive cells were extracted and subclustered to identify immune subpopulations and their dynamics during follicular remodeling. Spatial annotations of follicle types and corpus albicans regions were integrated from QuPath. Spatial visualization was performed using Matplotlib in Python and ggplot2 in R. Cell niche identification and neighborhood enrichment analysis were performed using CellCharter and Squidpy.

Expected outputs include processed AnnData objects, cell-cluster annotations, differentially expressed gene tables, immune subcluster annotations, niche-enrichment results, neighborhood-enrichment matrices and spatial visualization plots.

## Imaging Mass Cytometry data analysis

IMC data processing began by converting raw MCD files to TIFF files using steinbock. Cell segmentation was performed using the DeepCell module and refined with CellPose. Marker intensities were extracted and imported into R for downstream analysis using imcRtools, cytomapper and SpatialExperiment.

After arcsinh transformation, dimensionality reduction using t-SNE and clustering using Phenograph were performed. Clusters were annotated based on protein marker expression and spatial localization. Follicular regions were manually annotated in QuPath. Immune-cell subsets were further analyzed, and spatial neighborhood relationships were assessed with Squidpy. Visualization of spatial data was performed using ComplexHeatmap and cytomapper.

Expected outputs include segmented single-cell IMC data, protein-defined cell clusters, immune subclusters, marker-expression heatmaps, spatial cell maps and neighborhood-enrichment results.

## Reproducing the analysis

To reproduce the analysis, download the deposited input files from figshare and update the input paths in the scripts to match the local file locations. The scripts are organized according to the main analysis steps, including Xenium preprocessing, cell clustering, immune-cell subclustering, spatial niche analysis, neighborhood analysis, IMC processing and figure generation.

Because the full datasets are large, runtime will vary depending on hardware, memory and storage speed.

## Demo dataset

No separate simulated or small demo dataset is provided. The scripts are intended to be run on the deposited Xenium and IMC datasets described above.

